package lab02.juancamiloguerreroalarcon.juanjoseescuderovalencia.santiagopulgarinvasquez;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author spulgarinv && jcguerrera && jjescuderv
 */
public class Point1 {

    /**
     *
     * @param g Fully directed graph 
     * @param o beginning and end of node
     * @return Whole value with the minimum cost
     */
    public static int calcPerm(Digraph g, int o){
        boolean[] visit = new boolean[g.size()];
        int[] cost = new int[1];
        cost[0] = Integer.MAX_VALUE;
        perm(g, o, o, visit, cost, 0, 0);
        return cost[0] == Integer.MAX_VALUE ? 0 : cost[o];
    }

    /**
     *
     * @param g Grafo completamente dirigido
     * @param o Origen del nodo
     * @param d Fin del nodo
     * @param visit Visited nodes that are contained in the Array
     * @param cost Size 1 array that stores the minimum cost
     * @param size Cumulative size value
     * @param vertex Number of nodes
     * @return
     */

    public static int perm (Digraph g, int o, int d, boolean[] visit,int[] cost, int size, int vertex){
        visit[o] = true;
        int x = Integer.MAX_VALUE;

        if(vertex!= g.size)
            vertex++;

        if(o == d && g.size() == vertex){
            if(size < cost[0]){
                cost[0] = size;
            }
            return cost[0];
        }
        ArrayList<Integer> hijos = g.getSuccessors(o);

        for (Integer hijo : hijos) {

            int tempCost = g.getWeight(o,hijo);

            if((!visit[hijo]) || (hijo == d && vertex == g.size())){
                size += tempCost;
                x = Math.min(perm(g, hijo, d, visit, cost, size, vertex),x);
            }
        }
        return x;
    }

    public static void generator(){

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 49 ; j++) {
                System.out.println("g1.addArc(" +i+","+ j +"," + ThreadLocalRandom.current().nextInt(1, 5)+ ");");
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
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

        System.out.println(calcPerm(g1,0));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+ estimatedTime +" ms");


    }
    
}
