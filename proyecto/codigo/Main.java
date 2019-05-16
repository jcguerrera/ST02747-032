import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Juan Camilo Guerrero, Santiago Pulgarin, Juan Jose Escudero
 */
public class Main {
    /**
     *
     * @param args
     * Metodo que ejecuta el algoritmo
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int U = in.nextInt();
        double p = in.nextDouble();
        in.close();
        DigraphAM graph = readFile(U, p);
        ArrayList<ArrayList<Estudiante>> cars = carAssignment(graph, p);
        saveFile(cars, U, p);
    }

    /**
     *
     * @param u Numero de nodos
     * @param p Constante de tiempo
     * @return grafo g
     * Metodo empleado para leer y guardar el archivo en una matriz de adyacencia
     */

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

    /**
     *
     * @param arr Arraylist que contiene cada carro y sus pasajeros
     * @param u Numero de nodos
     * @param p Constante de tiempo
     * Metodo de escritura del archivo respuesta
     */
    private static void saveFile (ArrayList<ArrayList<Estudiante>> arr, int u, double p) {
        try {
            PrintWriter wr = new PrintWriter("respuesta-dataset-ejemplo-U=" + u + "-p=" + p + ".txt", "UTF-8");
            for (ArrayList<Estudiante> a: arr){
                for(Estudiante e : a) {
                    wr.print(e.getNode() + " ");
                }
                wr.println();
            }
            wr.close();
        }
        catch(Exception e) {
            System.out.println("Error escribiendo el archivo de salida: " + e.getMessage() );
        }
    }

    /**
     *
     * @param g Grafo
     * @param succArr Sucesores del nodo
     * @param ini Node
     * @return Arreglo del objeto estudiantes ordenado
     */
    private static Estudiante[] successorsSort(DigraphAM g, ArrayList<Integer> succArr, int ini) {
        Estudiante[] eArr = new Estudiante[succArr.size()];

        for(int i = 0; i < succArr.size(); i++) {
            int vertex = succArr.get(i);
            eArr[i] = new Estudiante(vertex, g.getWeight(ini, vertex));
        }

        Arrays.sort(eArr, new SortWeight());
        return eArr;
    }

    /**
     *
     * @param g Grafo
     * @param p Constante p
     * @return Arraylist que contiene cada carro con sus psajeros
     */
    private static ArrayList<ArrayList<Estudiante>> carAssignment(DigraphAM g, double p) {
        ArrayList<ArrayList<Estudiante>> totCars = new ArrayList();
        Estudiante[] destinationScc = successorsSort(g, g.getSuccessors(1), 1);
        boolean[] visited = new boolean[g.size()];
        visited[0] = true;

        for(int i = destinationScc.length-1; i >= 0; i--) {
            ArrayList<Estudiante> car = new ArrayList();
            Estudiante driver = destinationScc[i];
            int node = driver.getNode();
            if (!visited[driver.getNode() - 1]) car.add(driver);
            visited[node - 1] = true;

            int acumWeight = 0;
            double maxWeight = driver.getWeight() * p;

            ArrayList<Integer> driverScc = g.getSuccessors(driver.getNode());

            for (int j = 0; j < driverScc.size(); j++) {
                int passenger = driverScc.get(j);
                int pathWeight = g.getWeight(node, passenger);

                if (!visited[passenger - 1]) {
                    if ((acumWeight + pathWeight) + g.getWeight(1, passenger) < maxWeight) {
                        acumWeight += pathWeight;
                        car.add(new Estudiante(passenger, 0));
                        visited[passenger - 1] = true;
                        node = passenger;
                        if (car.size() == 5) break;
                    }
                }
            }

            if(car.size()>0) totCars.add(car);
        }

        return totCars;
    }

}