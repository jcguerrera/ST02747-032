import java.util.ArrayList;

public class Taller7 {

     private int prim(Digraph g, int inicio) {
          int total = 0;
          boolean[] visitados = new boolean[g.size()];
          ArrayList<Integer> nodosPadre = new ArrayList();

          for(int i = 0; i < g.size()-1; i++) {
               visitados[inicio] = true;
               int menor = Integer.MAX_VALUE;
               nodosPadre.add(inicio);

               for(Integer nodo : nodosPadre) {
                    ArrayList<Integer> hijos = g.getSuccessors(nodo);

                    for(Integer hijo : hijos) {
                         if(!visitados[hijo] && g.getWeight(nodo, hijo) < menor) {
                              menor = g.getWeight(nodo, hijo);
                              inicio = hijo;
                         }
                    }
               }

               total += menor;
          }

          return total;
     }

     public static void main(String[] args) {
          Taller7 a = new Taller7();
          int min = 0;

          DigraphAL g1 = new DigraphAL(5);
          g1.addArc(0, 1, 4);
          g1.addArc(0, 2, 4);
          g1.addArc(0, 3, 6);
          g1.addArc(0, 4, 6);
          g1.addArc(1, 0, 4);
          g1.addArc(1, 2, 2);
          g1.addArc(2, 0, 4);
          g1.addArc(2, 1, 2);
          g1.addArc(2, 3, 8);
          g1.addArc(3, 0, 6);
          g1.addArc(3, 2, 8);
          g1.addArc(3, 4, 9);
          g1.addArc(4, 0, 6);
          g1.addArc(4, 3, 9);


          System.out.println(a.prim(g1, 0));
     }

}
