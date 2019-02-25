import java.util.Scanner;

/**
 * Laboratorio 2.
 *
 * @author Juan Camilo Guerrero, Santiago Pulgarin, Juan José Escudero
 */

public class NReinas
{
    static int s;
    
    public static void main(String args[]) {
       NReinas classIns = new NReinas();
       classIns.lectura();
    }
    
    private void nReinas(int n, int[] tablero, int c, boolean[][] mat) {
        if(c == n) {
            if(!seAtacanHastaCoNo(tablero, c)) {
                s++;
            }
        } else {
            for (int i = 0; i < n; i++) {
                tablero[c] = i;
                if(!mat[i][c] && !seAtacanHastaCoNo(tablero, c)) {
                    nReinas(n, tablero, c+1, mat);
                }
            }
        }
    }
    
    private boolean seAtacanHastaCoNo(int[] tablero, int c) {
        for(int i = 0; i < c-1; i++) {
            for(int j = i+1; j < c; j++) {
                if(pendiente(i, j, tablero[i], tablero[j])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean pendiente(double x1, double x2, double y1, double y2) {
        if(((y2-y1)/(x2-x1) == -1) || ((y2-y1)/(x2-x1) == 0) || ((y2-y1)/(x2-x1) == 1)) 
            return true;
        return false;
    }
    
    public void lectura() {
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        
        while(index != 0) {
            s = 0;
            boolean[][] mat = new boolean[index][index];
            for(int i = 0; i < index; i++) {
                String line = in.next();
                for(int j = 0; j < index; j++) {
                    if(line.charAt(j)=='*') {
                        mat[i][j] = true;
                    }
                }
            }
            
            nReinas(index, new int[index], 0, mat);
            System.out.println(s);
            index = in.nextInt();
        }
    }
}
