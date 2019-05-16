public class Estudiante {
    /**
     * Clase estudiante que contiene la informacion del nodo y el peso que hay de cada uno
     * al punto destino
     */
    int node;
    int weight;
    boolean picked;

    public Estudiante(int node, int weight) {
        this.node = node;
        this.weight = weight;
        this.picked = false;
    }

    public void setPicked() { this.picked = true; }
    public boolean getPicked() { return this.picked; }
    public int getNode() { return this.node; }
    public int getWeight() { return this.weight; }
}
