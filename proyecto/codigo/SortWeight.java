import java.util.Comparator;

class SortWeight implements Comparator<Estudiante> {

    public int compare(Estudiante a, Estudiante b) {
        return a.weight - b.weight;
    }

}
