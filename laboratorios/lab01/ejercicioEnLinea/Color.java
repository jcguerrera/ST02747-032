import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author spulgarinv , jcguerrera && jjescuderv
 *
 */


public class Color {

    /**
     *
     * @param args
     */

    /*
        Algorithm in charge of using the main function
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nod = sc.nextInt();
        while (nod != 0) {
            DigraphAM g = new DigraphAM(nod);
            int arcos = sc.nextInt();
            for (int i = 0; i < arcos; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                g.addArc(n1, n2, nod);
            }
            System.out.println(isBicolorable(g));
            nod = sc.nextInt();
        }
    }

    /*
    Method responsible for analyzing
     the adjacency matrix,
    verifying each of the positions
     */

    /**
     *
     * @param g
     * @return BICOLORABLE
     */

    public static String isBicolorable(DigraphAM g) {
        int n = g.size;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        color[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {

                if (g.getWeight(j, i) != 0 && color[i] == -1) {

                    color[i] = 1 - color[j];

                } else if (g.getWeight(j, i) != 0 && color[j] == color[i]) {
                    return "NOT BICOLORABLE";
                }
            }
        }

        return "BICOLORABLE";
    }
}
