/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.ifba.controller;

import br.com.ifba.model.Usuario;
import br.com.ifba.model.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author joeziojr
 */
public class LoginViewController{


    @FXML
    private Label loginLbl;
    @FXML
    private TextField loginTxtEmail;
    @FXML
    private PasswordField loginPasswordTxt;
    @FXML
    private Button loginBtn;
    /**
     * Initializes the controller class.
     */
     private UsuarioDAO userDao = new UsuarioDAO();
     
     public void onLoginBtnAction() throws IOException {
         fazerLogin();
    }

    //Método que  verifica a existência de uma conta, verificando o email
    public void fazerLogin() throws IOException {
        if (validarCampos()) {
            Usuario us = userDao.pesquisarUser(loginTxtEmail.getText(),
                    loginTxtEmail.getText(), loginPasswordTxt.getText());
            if (us.getId() > 0) {
                JOptionPane.showMessageDialog(null, "Fez o login");
               // return true;
            }
            if (us.getId() == 0) {
                JOptionPane.showMessageDialog(null, "User não cadastrado");
                //return false;
            }
        }
        //return false;
    }

    public boolean validarCampos() {
        if (loginTxtEmail.getText().equals("") || (loginPasswordTxt.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Há campos vazios");
            return false;
            //Implementar lógica aqui
        } else {
            return true;
        }
    }

}
