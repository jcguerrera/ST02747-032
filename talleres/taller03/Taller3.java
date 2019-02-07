package taller3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller 3
 *
 * @author Mauricio Toro, Camilo Paez
 */
public class Taller3 {

   
    /**
     * Metodo auxiliar para llamar el metodo posterior
     *
     * @param n numero de reinas
     * @return numero de soluciones
     */
    public static void nReinas(int n) {
        nReinas(n, new int[n], 0);
    }

    /**
     * Metodo devuelve el numero de soluciones que tiene el problema
     *
     * @param r fila
     * @param n numero de reinas
     * @return numero de soluciones
     */
    private static boolean nReinas(int n, int[] tablero, int c) {
        if (c == n) {
            imprimirTablero(tablero);
            return true;
        } else if (seAtacanHastaIoNo(tablero,c)) {
            
        }
        return false;
    }
    
    private static boolean seAtacanHastaIoNo (int [] tablero,int elI ) {
        for (int i=0; i<elI - 1; i++) 
            for (int j=i+1; j<elI; j++) 
                if (Math.abs (tablero[i] - tablero[j]) == Math.abs(i - j))
                    return false;
        return true;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Metodo que recorre un grafo por dfs
     *
     * @param g grafo ya implementado
     * @param inicio nodo inicial
     * @param fin nodo final
     * @return una lista con el camino encontrado
     */
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {

    }

    /**
     * Metodo que implemeta un recorrido de un grafo por profundidad (dfs)
     *
     * @param g grafo ya implementado
     * @param nodo nodo desde el cual se empezara hacer la busqueda
     * @param objetivo hasta donde se quiere llegar
     * @param visitados representa los nodos que ya se verificaron
     * @param list la lista con el camino encontrados
     * @return una lista con el camino
     */
    private static ArrayList dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {

    }

}
