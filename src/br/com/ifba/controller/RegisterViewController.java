/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.ifba.controller;

import static br.com.ifba.model.PasswordEncryptor.encryptPassword;
import br.com.ifba.model.Usuario;
import br.com.ifba.model.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class RegisterViewController {

   @FXML
    private Label registerLbl;
    @FXML
    private TextField registerTxtNome;
    @FXML
    private TextField registerTxtEmail;
    @FXML
    private PasswordField registerPasswordTxt;
    @FXML
    private PasswordField registerPasswordConfirm;
    @FXML
    private Button registerBtn;

    private UsuarioDAO user = new UsuarioDAO();
    

    /**
     * Initializes the controller class.
     */
    //Método de cadastro
    @FXML
    public void onRegisterBtnAction() throws IOException {
        cadastrar(registerTxtEmail.getText(), registerTxtNome.getText(), registerPasswordTxt.getText());
    }

    public void cadastrar(String txtEmail, String txtName, String txtPassword) throws IOException {
        if (validarCampos(registerTxtEmail.getText(), registerTxtNome.getText(), registerPasswordTxt.getText(), registerPasswordConfirm.getText())) {
            Usuario user = new Usuario();
            user.setEmail(txtEmail);
            user.setNome(txtName);
            user.setSenha(encryptPassword(txtPassword));

            if (UsuarioDAO.insert(user)) {
                
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ifba/view/LoginView.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                String css = this.getClass().getResource("/br/com/ifba/styleSheets/style.css").toExternalForm();
                scene.getStylesheets().add(css);

                stage.setScene(scene);
                stage.setTitle("login");
                stage.centerOnScreen();
                stage.show();


            } else if (!UsuarioDAO.insert(user)) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            }
        }

    }

    /*Método que confere se os dados foram inseridos e se as senhas batem
        Ele também verifica a existência do usuário no banco*/
    public boolean validarCampos(String txtEmail, String txtName, String txtPassword, String txtPasswordConfirm) {

        boolean isIt = false;

        Usuario us = user.pesquisarPorEmail(txtEmail);
        Usuario u2 = user.pesquisarPorNome(txtName);

        if (us.getId() > 0) {
            JOptionPane.showMessageDialog(null, "Email já cadastrado");
        } else if (us.getId() == 0) {
            if (u2.getId() > 0) {
                JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado");
            } else if (u2.getId() == 0) {
                if ((txtEmail.equals("") == false)
                        && (txtName.equals("") == false)
                        && (txtPassword.equals("") == false)) {

                    if (txtPassword.equals(txtPasswordConfirm)) {
                        isIt = true;
                    } else if (txtPassword.equals(txtPasswordConfirm) == false) {
                        JOptionPane.showMessageDialog(null, "Senhas não coincidem");
                        isIt = false;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Há campos vazios");
                    isIt = false;
                }
            }

        }
        return isIt;
    }

}
