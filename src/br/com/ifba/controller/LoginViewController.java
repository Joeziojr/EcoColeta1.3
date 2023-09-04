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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    @FXML
    private Button loginRegisterBtn;
    
    
     private UsuarioDAO userDao = new UsuarioDAO();
     
     public void onLoginBtnAction() throws IOException {
         fazerLogin();
     }
     
     public void onLoginRegisterBtnAction() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ifba/view/RegisterView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("/br/com/ifba/styleSheets/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("Registro");
        stage.centerOnScreen();
        stage.show();
     }
     
    

    //Método que  verifica a existência de uma conta, verificando o email
    public void fazerLogin() throws IOException {
        if (validarCampos()) {
            Usuario us = userDao.pesquisarUser(loginTxtEmail.getText(),
                    loginTxtEmail.getText(), loginPasswordTxt.getText());
            if (us.getId() > 0) {
                JOptionPane.showMessageDialog(null, "Fez o login");
               // return true;
               
               Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ifba/view/MainView.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                String css = this.getClass().getResource("/br/com/ifba/styleSheets/style.css").toExternalForm();
                scene.getStylesheets().add(css);

                stage.setScene(scene);
                stage.setTitle("Main");
                stage.centerOnScreen();
                stage.show();
               
               
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
