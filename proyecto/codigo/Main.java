import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int U = in.nextInt();
        double p = in.nextDouble();
        in.close();
        DigraphAM graph = readFile(U, p);
        carAssignment(graph, p);
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

    private static Estudiante[] successorsSort(DigraphAM g, ArrayList<Integer> succArr, int ini) {
        Estudiante[] eArr = new Estudiante[succArr.size()];

        for(int i = 0; i < succArr.size(); i++) {
            int vertex = succArr.get(i);
            eArr[i] = new Estudiante(vertex, g.getWeight(ini, vertex));
        }

        Arrays.sort(eArr, new SortWeight());
        return eArr;
    }

    private static void carAssignment(DigraphAM g, double p) {
        Estudiante[] eafitScc = successorsSort(g, g.getSuccessors(1), 1);
        boolean[] visited = new boolean[g.size()];

        for(int i = eafitScc.length-1; i >= 0; i--) {
            ArrayList<Estudiante> car = new ArrayList();
            Estudiante driver = eafitScc[i];
            int node = driver.getNode();
            if(!visited[driver.getNode()-1]) car.add(driver);
            visited[node-1] = true;

            int acumWeight = 0;
            double maxWeight = driver.getWeight() * p;

            Estudiante[] driverScc = successorsSort(g, g.getSuccessors(node), node);

            for(int j = 0; j < driverScc.length; j++) {
                Estudiante passenger = driverScc[j];
                int pathWeight = g.getWeight(node, passenger.getNode());

                if(!visited[passenger.getNode()-1]) {
                    if((acumWeight + pathWeight) + passenger.getWeight() < maxWeight) {
                        acumWeight+=pathWeight;
                        car.add(passenger);
                        visited[passenger.getNode()-1] = true;
                        node = passenger.getNode();
                        if(car.size() == 5) break;
                    }
                }
            }

            if(car.size() > 0) printCars(car);
        }
    }

    private static void printCars(ArrayList<Estudiante> arr) {
        for(Estudiante e : arr) {
            System.out.print(e.getNode() + " ");
        }
        System.out.println();
    }

}
