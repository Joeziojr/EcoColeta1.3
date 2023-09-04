/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.ifba.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joeziojr
 */
public class MainViewController implements Initializable {

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
