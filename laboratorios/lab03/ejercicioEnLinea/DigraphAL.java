import java.util.ArrayList;
import java.util.Collections;

/**
 * @author spulgarinv, jcguerrera, jjescuderv
 */
public class DigraphAL extends Digraph {
	ArrayList<ArrayList<Pair<Integer, Integer>>> list;

	public DigraphAL(int size) {
		super(size);
		list = new ArrayList<>(size);
		for (int i = 0; i < size; ++i)
			list.add(i, new ArrayList<Pair<Integer, Integer>>());
	}

	public void addArc(int source, int destination, int weight) {
		list.get(source).add(Pair.makePair(destination, weight));
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> s = new ArrayList<>(list.get(vertex).size());
		for (Pair<Integer, Integer> p : list.get(vertex))
			s.add(p.first);
		return s;
	}

	public int getWeight(int source, int destination) {
		for (Pair<Integer, Integer> p : list.get(source))
			if (p.first == destination)
				return p.second;
		return 0;
	}
        

}