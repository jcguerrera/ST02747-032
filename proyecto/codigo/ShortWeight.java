import java.util.Comparator;

class SortWeight implements Comparator<Estudiante> {
    /**
     *
     * @param a
     * @param b
     * @return Dato parametrizado
     */
    public int compare(Estudiante a, Estudiante b) {
        return a.weight - b.weight;
    }

}