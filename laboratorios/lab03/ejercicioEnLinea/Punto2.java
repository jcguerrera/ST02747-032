import java.util.ArrayList;

/**
 * @author spulgarinv, jcguerrera, jjescuderv
 */

public class Punto2 {
    
    public static ArrayList costoMinimo (DigraphAL g) {
        boolean[] visitado = new boolean[g.size()];
        ArrayList respuesta = new ArrayList();
        int sumaMax = Integer.MAX_VALUE;
        int suma = 0;
        boolean a = costoMinimoAux(g, 0, visitado, respuesta, suma, sumaMax,false);
        if (a) {
            for (int i = 0; i < respuesta.size() - 1; i++) {
                System.out.print(respuesta.get(i) + ", ");
            }
            System.out.print(respuesta.get(respuesta.size() - 1));
            return respuesta;
        } else {
            System.out.println("-1");
            ArrayList b = new ArrayList();
            return b;
        }
    }
    
    public static boolean costoMinimoAux (Digraph g, int o, boolean[] visitado, ArrayList respuesta, int suma, int sumaMax, boolean a) {
        if (o == g.size()-1) {
            respuesta.add(o);
            sumaMax = suma;
            a = true;
        }
        visitado[o] = true;
        respuesta.add(o);
        ArrayList<Integer> hijos = g.getSuccessors(o);
        for (int hijo : hijos) {
             if (!visitado[hijo] && g.getWeight(o, hijo) + suma < sumaMax) {
                 suma += g.getWeight(o, hijo);
                 a = costoMinimoAux(g, hijo, visitado, respuesta, suma, sumaMax, a);
             }
        }
        visitado[o] = false;
        return a;
    }
    
    
    public static void main(String[] args) {
        DigraphAL g = new DigraphAL(6);
        g.addArc(1, 2, 2);
        g.addArc(2, 1, 2);
        g.addArc(2, 5, 5);
        g.addArc(5, 2, 5);
        g.addArc(2, 3, 4);
        g.addArc(3, 2, 4);
        g.addArc(1, 4, 1);
        g.addArc(4, 1, 1);
        g.addArc(4, 3, 3);
        g.addArc(3, 4, 3);
        g.addArc(3, 5, 1);
        g.addArc(5, 3, 1);
        costoMinimo(g);
    }
}
