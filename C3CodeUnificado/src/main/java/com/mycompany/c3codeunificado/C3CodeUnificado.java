/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.c3codeunificado;

/**
 *
 * @author CamilaAlfaro
 */
public class C3CodeUnificado {

    public static void main(String[] args) {
        System.out.println("Camila Alfaro Rivera - CE #3\n");
        System.out.println("1. Ejercicio - ARBOL BINARIO\n");

        //1.a precarga del arbol con la estructura de 50, 30, 80, 25, 17, 38, 65, 90,78
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = {50, 30, 80, 25, 17, 38, 65, 90, 78};

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        System.out.println("arbol precargado con los valores: 50, 30, 80, 25, 17, 38, 65, 90, 78");
        System.out.println("Recorrido en orden: ");
        arbol.inOrden();
        System.out.println("\n");

        //1.b call el metodo de buscar con los valores 17 y 63
        int valor1 = 17;
        int valor2 = 63;

        boolean encontrado1 = arbol.buscar(valor1);
        boolean encontrado2 = arbol.buscar(valor2);

        if (encontrado1) {
            System.out.println("El " + valor1 + " si se encuentra en el arbol");
        } else {
            System.out.println("El " + valor1 + " no se encuentra en el arbol");
        }

        if (encontrado2) {
            System.out.println("El " + valor2 + " si se encuentra en el arbol");
        } else {
            System.out.println("El " + valor2 + " no se encuentra en el arbol");
        }

        //1.c obtner e imprimir nodos impares
        int[] nodosImpares = arbol.obtenerNodosImpares();

        System.out.print("Los nodos impares del arbol son: ");
        for (int i = 0; i < nodosImpares.length; i++) {
            System.out.print(nodosImpares[i]);
            if (i < nodosImpares.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".");

        System.out.println("\n2. Ejercicio - GRAFO BPM\n");

        //2.c.i se crear el grafo para bpm
        Grafo grafoBPM = new Grafo(5);

        //2.c.ii los 5 nodos segun la imagen del doc 
        grafoBPM.insertarNodo("Inicio", "(NA)");
        grafoBPM.insertarNodo("Recibir Documentos", "(Tcnico)");
        grafoBPM.insertarNodo("Analizar Solicitud", "(Analista)");
        grafoBPM.insertarNodo("Aprobar Solicitud", "(Jefe)");
        grafoBPM.insertarNodo("Terminar", "(NA)");

        //2.c.iii incialice matriz de adyacencia
        grafoBPM.agregarArista(0, 1, "Iniciar");
        grafoBPM.agregarArista(1, 2, "Enviar");
        grafoBPM.agregarArista(2, 3, "Evaluar");
        grafoBPM.agregarArista(3, 4, "Aprobar");

        //2.c.iv se imprime matriz de adyacencia
        grafoBPM.imprimirMatrizAdyacencia();

        //2.c.v se recorre e imprime info de los nodos
        grafoBPM.recorrerEImprimir(0);
    }
}
