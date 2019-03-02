import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller 6
 *
 * @author Mauricio Toro, Andres Paez
 */
public class Taller6 {
    /**
     * Metodo que dado un entero n y un conjunto de denominciones de dinero
     * busque la manera optima de dar el cambio
     * @param n cantidad a devolver
     * @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
     * @return un conjunto de unidades por denominacion
     */
    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int[] respuesta = new int[denominaciones.length];
        for(int i = 0; i < denominaciones.length; i++) {
            int cantidad = n/denominaciones[i];
            n = n % denominaciones[i];
            respuesta[i] = cantidad;
        }        
        return n!=0 ? null : respuesta;
    }

    /**
     * Metodo que recorre todo el grafo con la intencion de buscar un
     * camino que represente el menor costo pasando por todos los vertices exactamente
     * una vez y vuelva al nodo inicial
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g) {
        boolean[] visitados = new boolean[g.size()];
        int respuesta = 0;
        int node = 0;
        int snode = 0;
        
        for(int i = 0; i < g.size(); i++) {
            int menor = Integer.MAX_VALUE;
            visitados[node] = true;
            ArrayList<Integer> hijos = g.getSuccessors(node);
            
            for(Integer hijo : hijos) {
                int peso = g.getWeight(node, hijo);
                if((!visitados[hijo] && peso < menor) || (i==g.size()-1 && hijo==0)) {
                    menor = peso;
                    snode = hijo;
                }
            }
            respuesta += menor;
            node = snode;
        }

        return respuesta;
    }
}