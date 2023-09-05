/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.ifba.controller;

import br.com.ifba.model.Catador;
import br.com.ifba.model.CatadorDAO;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author joeziojr
 */
public class SelectMaterialsController{

    @FXML
    private Pane topPaneMainView;
    @FXML
    private CheckBox plasticoCheckBox;
    @FXML
    private CheckBox vidroCheckBox;
    @FXML
    private CheckBox papelCheckBox;
    @FXML
    private CheckBox metalCheckBox;
    @FXML
    private CheckBox MadeiraCheckBox;
    @FXML
    private TextField outroMaterialTextField;
    @FXML
    private Button SelectMaterialsBtn;

    /**
     * Initializes the controller class.
     */
    
    public void onSelectMaterialsBtnAction() throws IOException {
        selecaoCatador();
        
    }


    public Catador selecaoCatador(){
        Catador cat = new Catador();
        CatadorDAO catDAO = new CatadorDAO();

        if(MadeiraCheckBox.isArmed()){
            cat = catDAO.selecionarCatador("madeira");
            JOptionPane.showMessageDialog(null,
                    "Dados do catador apto para esta coleta:" + "\n" +
                    "Nome: " + cat.getNome() + "\n" +
                    "Idade: " + Integer.toString(cat.getIdade()) + "\n" +
                    "Telefone: " + cat.getTelefone() + "\n" +
                    "Avaliação: " + cat.getAvaliacao());
        } else 
            if(vidroCheckBox.isArmed()){
            cat = catDAO.selecionarCatador("vidro");
            JOptionPane.showMessageDialog(null,
                    "Dados do catador apto para esta coleta:" + "\n" +
                    "Nome: " + cat.getNome() + "\n" +
                    "Idade: " + Integer.toString(cat.getIdade()) + "\n" +
                    "Telefone: " + cat.getTelefone() + "\n" +
                    "Avaliação: " + cat.getAvaliacao());
        }else 
            if(plasticoCheckBox.isArmed()){
            cat = catDAO.selecionarCatador("plastico");
            JOptionPane.showMessageDialog(null,
                    "Dados do catador apto para esta coleta:" + "\n" +
                    "Nome: " + cat.getNome() + "\n" +
                    "Idade: " + Integer.toString(cat.getIdade()) + "\n" +
                    "Telefone: " + cat.getTelefone() + "\n" +
                    "Avaliação: " + cat.getAvaliacao());
        }else 
            if(metalCheckBox.isArmed()){
            cat = catDAO.selecionarCatador("metal");
            JOptionPane.showMessageDialog(null,
                    "Dados do catador apto para esta coleta:" + "\n" +
                    "Nome: " + cat.getNome() + "\n" +
                    "Idade: " + Integer.toString(cat.getIdade()) + "\n" +
                    "Telefone: " + cat.getTelefone() + "\n" +
                    "Avaliação: " + cat.getAvaliacao());
        }else 
            if(papelCheckBox.isArmed()){
            cat = catDAO.selecionarCatador("papel");
            JOptionPane.showMessageDialog(null,
                    "Dados do catador apto para esta coleta:" + "\n" +
                    "Nome: " + cat.getNome() + "\n" +
                    "Idade: " + Integer.toString(cat.getIdade()) + "\n" +
                    "Telefone: " + cat.getTelefone() + "\n" +
                    "Avaliação: " + cat.getAvaliacao());
        }
        
        return cat;
    }
    
}
