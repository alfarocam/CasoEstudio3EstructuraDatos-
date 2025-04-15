/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.c3codeunificado;

/**
 *
 * @author CamilaAlfaro
 */
public class NodoArbol {
    private int dato;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
}

