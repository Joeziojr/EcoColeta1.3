/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.ifba.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joeziojr
 */
public class MainViewController{

    @FXML
    private Pane bottomPaneMain;
    @FXML
    private Button homeButtonMain;
    @FXML
    private Button MapButtonMain;
    @FXML
    private Button ConfigButtonMain;
    @FXML
    private Pane topPaneMainView;
    @FXML
    private Button novaColetaMain;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void onDescarteBtnAction() throws IOException {
        
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/ifba/view/SelectMaterials.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("/br/com/ifba/styleSheets/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("SelecaoMateriais");
        stage.centerOnScreen();
        stage.show();
        
    }
    
}
