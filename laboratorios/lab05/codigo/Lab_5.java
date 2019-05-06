/**
 * @author Juan Camilo Guerrero, Santiago Pulgarin, Juan Jose Escudero
 * https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm#Complexity
 */
public class Lab_5 {

    /**
     * Dado un grafo completo, hallen el costo mínimo del recorrido que pasa por
     * todos los vértices exactamente una vez y vuelve al nodo inicial utilizando
     * programación dinámica
     * @param g grafo dado
     * para mas informacion
     * @see <a href="https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm">KMP</a>
     *
     */
    public static int heldKarp(Digraph g) {
        int n = g.size();
        int[][] costos = new int[n] [(int) Math.pow(2,n)];
        int[][] anteriores = new int[n] [(int) Math.pow(2,n)];
        for(int i = 0; i < n; i++) {
            costos[i][0] = g.getWeight(0, i);
            anteriores[i][0] = 0;

        }
        for (int i = 0; i < costos[0].length; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    costos[i][j] = 0;
                } else {
                    int val = (i - 1) - j;
                    if (j > n && val > 0 && val < n) {
                        costos[i][j] = 0;
                        costos[val][j] = 0;
                    } else {
                        if (i < n) {
                            costos[i][j] = costos[j][0] + g.getWeight(j, i);
                        }else{
                            int temp = j - i;
                            int val_ = j- temp - 1;
                            costos[i][j] = Math.max(costos[j-i][val_]
                                    +g.getWeight(temp,i),costos[val_][temp]
                                    +g.getWeight(val_,i));
                        }
                    }
                }
            }
        }

        return costos[0][(int)Math.pow(2,n)];
    }
}
