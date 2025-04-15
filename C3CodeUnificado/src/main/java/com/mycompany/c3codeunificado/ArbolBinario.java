/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.c3codeunificado;

/**
 *
 * @author CamilaAlfaro
 */
public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    // Método wrapper
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    // Método recursivo
    NodoArbol insertarRec(NodoArbol nodoActual, int valor) {
        if (nodoActual == null) {
            return new NodoArbol(valor);
        } else {
            if (valor < nodoActual.getDato()) {
                nodoActual.setIzquierda(insertarRec(nodoActual.getIzquierda(), valor));
            } else if (valor > nodoActual.getDato()) {
                nodoActual.setDerecha(insertarRec(nodoActual.getDerecha(), valor));
            }
        }
        return nodoActual;
    }

    // Recorridos de árboles
    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoArbol actual) {
        if (actual != null) {
            inOrdenRec(actual.getIzquierda());
            System.out.print(actual.getDato() + " ");
            inOrdenRec(actual.getDerecha());
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
    }
    // Método recursivo que recorre el árbol en preorden
    private void preOrdenRec(NodoArbol actual) {
        if (actual != null) {
            System.out.print(actual.getDato() + " ");
            preOrdenRec(actual.getIzquierda());
            preOrdenRec(actual.getDerecha());
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
    }
    // Método recursivo que recorre el árbol en postorden
    private void postOrdenRec(NodoArbol actual) {
        if (actual != null) {
            postOrdenRec(actual.getIzquierda());
            postOrdenRec(actual.getDerecha());
            System.out.print(actual.getDato() + " ");
        }
    }

    // Método envoltura que invoca el método recursivo.
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol eliminarRec(NodoArbol actual, int valor) {
        if (actual == null) return actual;

        if (valor < actual.getDato()) {
            actual.setIzquierda(eliminarRec(actual.getIzquierda(), valor));
        } else if (valor > actual.getDato()) {
            actual.setDerecha(eliminarRec(actual.getDerecha(), valor));
        } else {
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            }
            if (actual.getIzquierda() == null)
                return actual.getDerecha();
            else if (actual.getDerecha() == null)
                return actual.getIzquierda();

            NodoArbol sucesor = minValorSucedor(actual.getDerecha());
            actual.setDato(sucesor.getDato());
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getDato()));
        }
        return actual;
    }

    private NodoArbol minValorSucedor(NodoArbol nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    public int obtenerNivel(int valor, int nivel) {
        return obtenerNivelRec(raiz, valor, nivel);
    }

    public int obtenerNivelRec(NodoArbol actual, int valor, int nivel) {
        if (actual == null) return -1;
        if (actual.getDato() == valor) return nivel;

        int nivelIzq = obtenerNivelRec(actual.getIzquierda(), valor, nivel + 1);
        if (nivelIzq != -1) return nivelIzq;

        return obtenerNivelRec(actual.getDerecha(), valor, nivel + 1);
    }

    public int obtenerAltura(NodoArbol actual) {
        if (actual == null) return -1;

        int alturaIzq = obtenerAltura(actual.getIzquierda());
        int alturaDer = obtenerAltura(actual.getDerecha());

        return Math.max(alturaIzq, alturaDer) + 1;
    }
    
    // 1.b método para buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }
    
    private boolean buscarRec(NodoArbol actual, int valor) {
        if (actual == null) {
            return false;
        }
        
        if (valor == actual.getDato()) {
            return true;
        }
        
        if (valor < actual.getDato()) {
            return buscarRec(actual.getIzquierda(), valor);
        } else {
            return buscarRec(actual.getDerecha(), valor);
        }
    }
    
    //1.c Metodo para obtener nodos impares
    public int[] obtenerNodosImpares() {
        // se cuenta cuántos nodos impares hay
        int[] contador = {0};
        contarNodosImpares(raiz, contador);
        
        //se crea arrglo del tamaño exacto
        int[] nodosImpares = new int[contador[0]];
        
        //se llena el arreglo
        int[] indice = {0};
        llenarNodosImpares(raiz, nodosImpares, indice);
        
        return nodosImpares;
    }
    
    private void contarNodosImpares(NodoArbol actual, int[] contador) {
        if (actual != null) {
            if (actual.getDato() % 2 != 0) {
                contador[0]++;
            }
            contarNodosImpares(actual.getIzquierda(), contador);
            contarNodosImpares(actual.getDerecha(), contador);
        }
    }
    
    private void llenarNodosImpares(NodoArbol actual, int[] nodosImpares, int[] indice) {
        if (actual != null) {
            llenarNodosImpares(actual.getIzquierda(), nodosImpares, indice);
            
            if (actual.getDato() % 2 != 0) {
                nodosImpares[indice[0]] = actual.getDato();
                indice[0]++;
            }
            
            llenarNodosImpares(actual.getDerecha(), nodosImpares, indice);
        }
    }
}
