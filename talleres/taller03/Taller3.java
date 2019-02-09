import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller 3
 *
 * @author Juan Camilo Guerrero, Santiago Pulgarin, Juan Escudero
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


    private static void nReinas(int n, int[] tablero, int c) {
        if (c == n) {
            if (seAtacanHastaIoNo(tablero,n))
            imprimirTablero(tablero);

        } else {
            for (int i = 0; i < n ; i++) {
                tablero[c] = i;
                if (seAtacanHastaIoNo(tablero,c)){
                    nReinas(n,tablero,c + 1);
                }
            }

        }

    }

    private static boolean seAtacanHastaIoNo (int [] tablero,int elI ) {
        for (int i=0; i<elI - 1; i++)
            for (int j=i+1; j<elI; j++)
                if (Math.abs (tablero[i] - tablero[j]) == Math.abs(i - j) || tablero[i]== tablero[j])
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

    public static void main(String[] args) {
        nReinas(4);
    }
}
