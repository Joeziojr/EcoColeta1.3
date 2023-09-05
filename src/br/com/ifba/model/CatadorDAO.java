/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.model;

import static br.com.ifba.model.PasswordEncryptor.encryptPassword;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joeziojr
 */
public class CatadorDAO {
    
    public boolean insert(Catador catador) {

        String sql = "INSERT INTO catador (nome, email, senha, tipoDescartes, localizacao) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst;
            pst = Conexao.getConexao().prepareStatement(sql);
      
            pst.setString(1, catador.getNome());
            pst.setString(2, catador.getEmail());
            pst.setString(3, catador.getSenha());
            pst.setString(4, catador.getTipoDescartes());
            pst.setInt(5, catador.getLocalizacao());
            
      
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public Catador pesquisarCatador(String email, String name, String password) {
        String sql = "SELECT * FROM catador WHERE email = ? OR nome = ? AND senha = ?";
        Catador catador = new Catador();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, name);
            pst.setString(3, encryptPassword(password));
            rs = pst.executeQuery();

            if (rs.next()) {
                catador.setNome(rs.getString("nome"));
                catador.setEmail(rs.getString("email"));
                catador.setSenha(rs.getString("senha"));
                catador.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }

        return catador;
    }
    
    //Responsável por acessar dados como a localização e o tipo de descartes
    public Catador selecionarCatador(int localizacao, String tipoDescartes) {
        String sql = "SELECT * FROM catador WHERE localizacao = ? AND tipoDescartes = ?";
        Catador catador = new Catador();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setInt(1, localizacao);
            pst.setString(2, tipoDescartes);
            rs = pst.executeQuery();

            if (rs.next()) {
                catador.setTelefone(rs.getString("telefone"));
                catador.setAvaliacao(rs.getString("avaliacao"));
                catador.setNome(rs.getString("nome"));
                catador.setLocalizacao(rs.getInt("localizacao"));
                catador.setTipoDescartes(rs.getString("tipoDescartes"));
                catador.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }

        return catador;
    }

    ///Função que verifica e existência de um email no banco
    public Catador pesquisarPorEmail(String email) {
        String sql = "SELECT * FROM catador WHERE email = ?";

        Catador catador = new Catador();

        PreparedStatement pst;
        ResultSet rs;

        try {

            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while (rs.next()) {
                catador.setEmail(rs.getString("email"));
                catador.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return catador;
    }

    //Função que verifica e existência de um nome no banco
    public Catador pesquisarPorNome(String name) {
        String sql = "SELECT * FROM catador WHERE nome = ?";

        Catador catador = new Catador();

        PreparedStatement pst;
        ResultSet rs;

        try {

            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();

            while (rs.next()) {
                catador.setNome(rs.getString("nome"));
                catador.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return catador;
    }

    public boolean alterarSenha(Catador catador) {

        String sql = "UPDATE catador SET senha = ? WHERE email = ?";

        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, catador.getSenha());
            pst.setString(2, catador.getEmail());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    
    
}
