import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 4
 * 
 * @author Mauricio Toro, Andres Paez
 */
public class Taller4 {
    public static  boolean hayCamino(Digraph g, int o, int d){
        boolean[] visitados = new boolean[g.size()];    
        return hayCaminoAux(g, o, d, visitados);
    }

    private static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d)
            return true;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(o);          
            for (Integer hijo: hijos){
                if (!visitados[hijo] && hayCaminoAux(g, hijo, d, visitados))
                    return true;
                else
                return false;
            }      
        }
    }

    public static int costoMinimo(Digraph g, int o, int d){
            boolean[] visitado = new boolean[g.size()];
            return costoMinimo(g, o, d, visitado);
    }

    private static int costoMinimo(Digraph g, int o, int d, boolean[] visitado) {
        visitado[o] = true;
        int costoMinimo = Integer.MAX_VALUE;
        int costoCamino = 0;
        if (o == d)
            return costoMinimo;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(o);
            if(hijos != null){
                for (Integer hijo : hijos) {
                    if (!visitado[hijo]) {
                        visitado[hijo] = true;
                        int costoCamino = costoMinimo(g, hijo,d, visitado) + g.getWeight(o, d);
                        if (costoCamino < costoMinimo){
                            costoMinimo = costoCamino;
                        }
                    }
                }
            }
            return costoMinimo;
        }
    }
    
    public static int recorrido(Digraph g, int v) {
        boolean[] arr = new boolean[g.size()];
        arr[v] = true;
        return recorrido(g, v, v, arr, Integer.MAX_VALUE, 0);
    }

    private static int recorrido(Digraph g, int ini, int v, boolean[] visited, int minimo, int acum) {
        ArrayList<Integer> hijos = g.getSuccessors(v);
        for(Integer hijo : hijos) {
            if(check(visited, v) && acum < minimo) {
                minimo = acum;
                visited = new boolean[g.size()];
                visited[ini] = true;
                acum = 0;
            } else if(!visited[hijo]) {
                acum = acum + g.getWeight(v, hijo);
                visited[v] = true;
                recorrido(g, ini, hijo, visited, minimo, acum);          
            }
        }
        return minimo;
    }
    
    private static boolean check(boolean[] a, int v) {
        for(int i = 0; i < a.length; i++) {
            a[v] = true;
            if(!a[i]) {
                return false;
            }
        }
        return true;
    }
}
