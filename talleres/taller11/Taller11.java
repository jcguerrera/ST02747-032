
/**
 * Clase en la cual se implementan los metodos del Taller 11
 * 
 * @author Mauricio Toro, Andres Paez
 */
public class Taller11 {
	/**
	* Dado un grafo completo, hallen el costo mínimo del recorrido que pasa por
	* todos los vértices exactamente una vez y vuelve al nodo inicial utilizando
	* programación dinámica
	* @param g grafo dado
	* @param y cadena de caracteres
	* para mas informacion
	* @see <a href="https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm">KMP</a>
	*
	*/
	public static int heldKarp(Digraph g) {
	    int n = g.size();
	    int[][] costos = new int[n] [(int) Math.pow(2,n)];
	    int[][] anteriores = new int[n] [(int) Math.pow(2,n)];
	    for(int i = 0; i < n; i++) {
	        costos[i][0] = g.getWeight(0,i);
	        anteriores[i][0] = 0;
	    }
	    for (int i = 0; i < n; i++) {
	       for (int j = 0; j < n; j++) {
	           costos[][];
	           anteriores[][];
	       }
	    }
	           
	    return costos[0][Math.pow(2,n);
	}
}
