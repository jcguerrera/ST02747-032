public class nQueens {

    public static void nReinas(int n) {
        nReinas(n, new int[n], 0);
    }

    private static boolean nReinas(int n, int[] tablero, int c) {
        if(c == n) {
            if(!seAtacanHastaCoNo(tablero, c)) {
                imprimirTablero(tablero);
                return true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                tablero[c] = i;
                if(!seAtacanHastaCoNo(tablero, c)) {
                    if(nReinas(n, tablero, c+1)) return true;
                }
            }
        }
        return false;
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
        nReinas(4);
    }
}
