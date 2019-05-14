public class Estudiante {
    int node;
    int peso;
    boolean visitado;
    boolean recogido;

    public Estudiante(int node, int peso) {
        this.node = node;
        this.peso = peso;
        this.visitado = false;
        this.recogido = false;
    }

    public void setVisitadoTrue() {
        this.visitado = true;
    }
    public void setRecogidoTrue() { this.recogido = true; }
    public int getPeso() { return this.peso; }
}
