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
        Arrays.sort(respuesta);
        for(int i = 0; i < denominaciones.length; i++) {
            int platica = n/denominaciones[i];
            n = n % denominaciones[i];
            respuesta[i] = platica;
        }
        return respuesta;
    }

    /**
     * Metodo que recorre todo el grafo con la intencion de buscar un
     * camino que represente el menor costo pasando por todos los vertices exactamente
     * una vez y vuelva al nodo inicial
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g) {
        int respuesta = 0;
        boolean[] visitados = new boolean[g.size()];

        for(int i = 0; i < g.size; i++) {
            int menor = Integer.MAX_VALUE;
            visitados[i] = true;
            ArrayList<Integer> hijos = g.getSuccessors(i);

            for (Integer hijo : hijos) {
                if(!visitados[hijo] && respuesta + g.getWeight(i,hijo) < menor || (i == hijo && i == g.size)) {
                    respuesta += g.getWeight(i,hijo);
                    if (respuesta < menor)
                    menor = respuesta;
                }
            }
        }
        return respuesta;
    }

    public static void main(String[] args) {
        DigraphAL g1 = new DigraphAL(5);
        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);
        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);
        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);
        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);
        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);
        System.out.println(recorrido(g1));

        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 2, 15);
        g2.addArc(2, 0, 15);
        g2.addArc(0, 3, 20);
        g2.addArc(3, 0, 20);
        g2.addArc(0, 1, 10);
        g2.addArc(1, 0, 10);
        g2.addArc(3, 1, 25);
        g2.addArc(1, 3, 25);
        g2.addArc(3, 2, 30);
        g2.addArc(2, 3, 30);
        g2.addArc(1, 2, 35);
        g2.addArc(2, 1, 35);
        g2.addArc(0, 0, 0);
        g2.addArc(1, 1, 0);
        g2.addArc(2, 2, 0);
        g2.addArc(3, 3, 0);
        System.out.println(recorrido(g2));


        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 0, 0);
        g3.addArc(0, 1, 7);
        g3.addArc(0, 2, 15);
        g3.addArc(0, 3, 6);
        g3.addArc(1, 0, 2);
        g3.addArc(1, 1, 0);
        g3.addArc(1, 2, 7);
        g3.addArc(1, 3, 3);
        g3.addArc(2, 0, 9);
        g3.addArc(2, 1, 6);
        g3.addArc(2, 2, 0);
        g3.addArc(2, 3, 12);
        g3.addArc(3, 0, 10);
        g3.addArc(3, 1, 4);
        g3.addArc(3, 2, 8);
        g3.addArc(3, 3, 0);
        System.out.println(recorrido(g3));

    }
}