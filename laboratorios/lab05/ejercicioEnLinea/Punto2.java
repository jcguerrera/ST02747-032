import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Punto2 {
    public static void main(String[] args) {
        readFile();
    }

    private static int heldKarp(Digraph g) {
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
                            int val_ = j - temp - 1;
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

    private static Digraph createGraph(ArrayList<Position> wPos) {
        DigraphAL g = new DigraphAL(wPos.size());
        int node = 0;
        for(int i = 0; i < g.size(); i++) {
            if(i != node) g.addArc(node, i, distance(wPos.get(node), wPos.get(i)));
            node++;
        }
        return g;
    }

    private static int distance(Position a, Position b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private static void readFile() {
        ArrayList<Position> wPos = new ArrayList();

        try {
            File dataset = new File("dataset.txt");
            FileReader in = new FileReader(dataset);
            BufferedReader br = new BufferedReader(in);

            String line;
            while((line=br.readLine()) != null) {
                line = br.readLine();

                line = br.readLine();
                String[] initalPos = line.split(" ");
                wPos.add(new Position(Integer.parseInt(initalPos[0]), Integer.parseInt(initalPos[1])));

                line = br.readLine();
                int n = Integer.parseInt(line);

                for(int i = 0; i < n; i++) {
                    line = br.readLine();
                    String[] w = line.split(" ");
                    wPos.add(new Position(Integer.parseInt(w[0]), Integer.parseInt(w[1])));
                }

                Digraph g = createGraph(wPos);
                System.out.println(heldKarp(g));

                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
