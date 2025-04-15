/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.c3codeunificado;

/**
 *
 * @author CamilaAlfaro
 */
public class NodoGrafo {

    private String nombreEtapa;
    private String rolEjecutor;
    private int valor;

    public NodoGrafo(int valor) {
        this.valor = valor;
        this.nombreEtapa = "";
        this.rolEjecutor = "";
    }

    public NodoGrafo(int valor, String nombreEtapa, String rolEjecutor) {
        this.valor = valor;
        this.nombreEtapa = nombreEtapa;
        this.rolEjecutor = rolEjecutor;
    }

    /**
     * Get the value of valor
     *
     * @return the value of valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Set the value of valor
     *
     * @param valor new value of valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public String getRolEjecutor() {
        return rolEjecutor;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public void setRolEjecutor(String rolEjecutor) {
        this.rolEjecutor = rolEjecutor;
    }

}
