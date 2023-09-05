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
public class DescarteDAO {
 
    
    public static boolean insert(Descarte descarte) {

        String sql = "INSERT INTO descarte (dono, material, quantidade, localizacao) values (?, ?, ?, ?)";

        try {
            PreparedStatement pst;
            pst = Conexao.getConexao().prepareStatement(sql);
      
            pst.setString(1, descarte.getDono());
            pst.setString(2, descarte.getMaterial());
            pst.setInt(3, descarte.getQuantidade());
            pst.setInt(4, descarte.getLocalizacao());
      
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public Descarte  pesquisarDescarte(String material, int localizacao, String dono) {
        String sql = "SELECT * FROM descarte WHERE material = ? AND localizacao = ? AND dono = ?";
        Descarte  descarte = new Descarte();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, material);
            pst.setInt(2, localizacao);
            pst.setString(3, dono);
            rs = pst.executeQuery();

            if (rs.next()) {
                descarte.setMaterial(rs.getString("material"));
                descarte.setLocalizacao(rs.getInt("localizacao"));
                descarte.setDono(rs.getString("dono"));
                descarte.setId(rs.getInt("id"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }

        return descarte;
    }
    
    
    
}
