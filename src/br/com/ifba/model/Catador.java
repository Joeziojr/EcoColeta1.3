/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.model;

/**
 *
 * @author joeziojr
 */
public class Catador extends Usuario {
    
    private String tipoDescartes;
    private String Avaliacao;
    private boolean aceita = false;

    public String getTipoDescartes() {
        return tipoDescartes;
    }

    public void setTipoDescartes(String tipoDescartes) {
        this.tipoDescartes = tipoDescartes;
    }

    public String getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(String Avaliacao) {
        this.Avaliacao = Avaliacao;
    }

    public boolean isAceita() {
        return aceita;
    }

    public void setAceita(boolean aceita) {
        this.aceita = aceita;
    }
    
    public boolean aceitarColeta(boolean aceita){
        this.setAceita(aceita);
        return this.aceita;
    }
    
    
    
    
}
