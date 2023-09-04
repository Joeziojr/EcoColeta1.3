/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static br.com.ifba.model.PasswordEncryptor.encryptPassword;

/**
 *
 * @author joeziojr
 */
public class UsuarioDAO {

    public static boolean insert(Usuario user) {

        String sql = "INSERT INTO usuario (nome, email, senha) values (?, ?, ?)";

        try {
            PreparedStatement pst;
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getSenha());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public Usuario pesquisarUser(String email, String name, String password) {
        String sql = "SELECT * FROM usuario WHERE email = ? OR nome = ? AND senha = ?";
        Usuario user = new Usuario();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, name);
            pst.setString(3, encryptPassword(password));
            rs = pst.executeQuery();

            if (rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }

        return user;
    }

    ///Função que verifica e existência de um email no banco
    public Usuario pesquisarPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        Usuario user = new Usuario();

        PreparedStatement pst;
        ResultSet rs;

        try {

            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }

    //Função que verifica e existência de um nome no banco
    public Usuario pesquisarPorNome(String name) {
        String sql = "SELECT * FROM usuario WHERE nome = ?";

        Usuario user = new Usuario();

        PreparedStatement pst;
        ResultSet rs;

        try {

            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();

            while (rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }

    public boolean alterarSenha(Usuario user) {

        String sql = "UPDATE usuario SET senha = ? WHERE email = ?";

        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, user.getSenha());
            pst.setString(2, user.getEmail());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

}
