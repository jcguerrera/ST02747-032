import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DigraphAM graph = readFile(205, 1.3);
    }

    private static DigraphAM readFile(int u, double p) {
        DigraphAM graph = new DigraphAM(u+1);

        try {
            String arch = "dataset-ejemplo-U=" + u + "-p=" + p + ".txt";
            BufferedReader br = new BufferedReader(new FileReader(new File(arch)));

            String line = br.readLine();
                for(int i = 0; i < 3; i++) { line = br.readLine(); }
                for(int i = 0; i < u; i++) { line = br.readLine(); }
                for(int i = 0; i < 3; i++) { line = br.readLine(); }

            while((line = br.readLine()) != null) {
                String[] linePart = line.split(" ");
                graph.addArc(Integer.parseInt(linePart[0]), Integer.parseInt(linePart[1]), Integer.parseInt(linePart[2]));
            }

        } catch(Exception e) { e.printStackTrace(); }

        return graph;
    }

    private void szs() {

    }

    /**
    private static void printGraph(DigraphAM g) {
        for(int i = 1; i < g.size(); i++) {
            System.out.println(1 + " " + i + " " + g.getWeight(1,i));
        }
    }
     */

}
