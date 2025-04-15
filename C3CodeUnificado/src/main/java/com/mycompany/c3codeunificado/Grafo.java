/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.c3codeunificado;

/**
 *
 * @author CamilaAlfaro
 */
public class Grafo {

    private NodoGrafo[] nodos;
    //2.a matruz de adyacencia strings para guardar acciones 
    private String[][] matrizAdyacencia;
    private int cantidadNodosActual;

    public Grafo(int cantidadNodos) {
        nodos = new NodoGrafo[cantidadNodos];
        //2.a se inicializa matriz con valores nulos
        matrizAdyacencia = new String[cantidadNodos][cantidadNodos];
        cantidadNodosActual = 0;

        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                matrizAdyacencia[i][j] = null;
            }
        }
    }

    //2.b metodo para que se inserte nodos con nombre de etapa y rol ejecutor 
    public void insertarNodo(String nombreEtapa, String rolEjecutor) {
        if (cantidadNodosActual < nodos.length) {
            nodos[cantidadNodosActual] = new NodoGrafo(cantidadNodosActual, nombreEtapa, rolEjecutor);
            cantidadNodosActual++;
        } else {
            System.out.println("No se logra agregar mas nodos el grafo se encuentra lleno");
        }
    }

    //2.a metodo para agregar la arista con accion
    public void agregarArista(int nodoOrigen, int nodoDestino, String accion) {
        if (nodoOrigen >= 0 && nodoOrigen < cantidadNodosActual
                && nodoDestino >= 0 && nodoDestino < cantidadNodosActual) {
            matrizAdyacencia[nodoOrigen][nodoDestino] = accion;
        } else {
            System.out.println("Nodos fuera de rango");
        }
    }

// 2.c.iv meotodo para imprimir matriz  adyacencia 
    public void imprimirMatrizAdyacencia() {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    //2.c.v. metodo recorrer e imprimir informacion de los nodos con el recorrido de Profundidad Recursivo modificado
    public void recorrerEImprimir(int nodoInicial) {
        System.out.println("\nRecorrido del proceso BPM:");
        boolean[] visitado = new boolean[nodos.length];
        recorrerEImprimirRecursivo(nodoInicial, visitado);
    }

    private void recorrerEImprimirRecursivo(int nodo, boolean[] visitados) {
        visitados[nodo] = true;
        System.out.println("Etapa: " + nodos[nodo].getNombreEtapa()
                + " - Ejecutor: " + nodos[nodo].getRolEjecutor());

        for (int i = 0; i < cantidadNodosActual; i++) {
            if (matrizAdyacencia[nodo][i] != null && !visitados[i]) {
                System.out.println("  Accion: " + matrizAdyacencia[nodo][i]);
                recorrerEImprimirRecursivo(i, visitados);
            }
        }
    }
}



//    
//    // RECORRIDO EN AMPLITUD
//    public NodoGrafo[] recorridoAmplitud(int nodoInicial) {
//        NodoGrafo[] nodosVisitados = new NodoGrafo[nodos.length];
//        boolean[] visitado = new boolean[nodos.length];
//        int frente = 0;
//        int finalCola = 0;
//        int[] cola = new int[nodos.length];
//        
//        visitado[nodoInicial] = true;
//        cola[finalCola++] = nodoInicial;
//        
//        while (frente != finalCola) {
//            int nodoPorAtender = cola[frente++];
//            nodosVisitados[frente - 1] = nodos[nodoPorAtender];
//            
//            for (int i = 0; i < nodos.length; i++) {
//                if (matrizAdyacencia[nodoPorAtender][i] == 1 && !visitado[i]) {
//                    visitado[i] = true;
//                    cola[finalCola++] = i;
//                }
//            }
//        }
//        
//        System.out.println("Nodos visitados a amplitud: ");
//        for (int i = 0; i < nodosVisitados.length && nodosVisitados[i] != null; i++) {
//            System.out.println(nodosVisitados[i].getValor());
//        }
//        
//        return nodosVisitados;
//    }
//}

    
