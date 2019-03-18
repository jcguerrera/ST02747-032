import java.util.ArrayList;

public class Lab3 {

    public static int costoMinimo(Digraph g, int o, int d){
        boolean[] visitado = new boolean[g.size()];
        return costoMinimo(g, o, d, visitado);
    }

    private static int costoMinimo(Digraph g, int o, int d, boolean[] visitado) {
        visitado[o] = true;
        int costoMinimo = Integer.MAX_VALUE;
        int costoCamino = 0;
        int snode = 0;
        if (o == d)
            return costoCamino;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(o);
                for (Integer hijo : hijos) {
                    if (!visitado[hijo]) {
                        visitado[snode] = true;
                        costoCamino = costoMinimo(g, hijo,d, visitado) + g.getWeight(o, hijo);
                        if (costoCamino <= costoMinimo){
                            costoMinimo = costoCamino;

                        }
                    }
                    snode = hijo;
                }
            return costoMinimo;
        }
    }

    public static void nReinas(int n) {
        nReinas(n, new int[n], 0);
    }

    private static void nReinas(int n, int[] tablero, int c) {
        int count = 0;
        if(c == n) {
            if(!seAtacanHastaCoNo(tablero, c)) {
                imprimirTablero(tablero);
            }
        } else {
            for (int i = 0; i < n; i++) {
                tablero[c] = i;
                if(!seAtacanHastaCoNo(tablero, c)) {
                    nReinas(n, tablero, c+1);
                }
            }
        }
    }

    private static boolean seAtacanHastaCoNo(int[] tablero, int c) {
        for(int i = 0; i < c-1; i++) {
            for(int j = i+1; j < c; j++) {
                if(pendiente(i, j, tablero[i], tablero[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean pendiente(double x1, double x2, double y1, double y2) {
        if(((y2-y1)/(x2-x1) == -1) || ((y2-y1)/(x2-x1) == 0) || ((y2-y1)/(x2-x1) == 1))
            return true;
        return false;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; j++) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

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

        System.out.println("El costo minimo es de: "+costoMinimo(g2,0,3));

        //nReinas(4);
    }
}

