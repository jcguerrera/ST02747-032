import java.util.ArrayList;

/**
 *
 * @author spulgarinv && jcguerrera
 */
class DigraphAM extends Graph {

    int[][] matriz;

    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
    }


    public int getWeight(int source, int destination) {
        return matriz[source][destination];
    }


    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }


    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors = new ArrayList();
        for(int i=0; i< super.size; i++)
            if(matriz[vertex][i] != 0)
                successors.add(i);
        return successors;
    }
}
