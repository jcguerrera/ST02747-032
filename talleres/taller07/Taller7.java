package taller7;

import java.util.Arrays;

public class Taller7 {
     public int[] llenarUnArregloConInfinitos(int n){
         int[] a = new int[n];
         Arrays.fill(a, Integer.MAX_VALUE);
         return a;
     }   
  
     private int elMasPequenoNoVisitado(Digraph g, boolean[] visitados, int[] tabla){
       
     }
  
     private void actualizarLosPesosDeLaTablaConElValorActual(Digraph g, int actual, int[] tabla){
    
     }
  
     public int[] dijkstra(Digraph g, int v){
          int[] tabla = llenarUnArrregloConInfinitos(g.size());
          int actual = v;
          boolean[] visitados = new boolean[g.size()];
          for (int i = 0; i < g.size(); i++) {
              actual = elMasPequenoNoVisitado(g, visitados, tabla);
              visitados[actual] = true;
              actualizarLosPesosDeLaTablaConElValorActual(g, actual, tabla);
          }
          return tabla;      
     }  
}
