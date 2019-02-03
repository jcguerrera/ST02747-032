package lab01.juancamiloguerreroalarcon.juanjoseescuderovalencia.santiagopulgarinvasquez;

/**
* This class must contain the solution to the problem raised in point 1
* of laboratory # 1 of the data structure course and algorithms II
* @author jcguerrera && jjescuderv && spulgarinv
* @version 1.0
*/

import javafx.util.Pair;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Point1{
    /**
     * The method should read the file and build the data structure with the map
     *
     */

    private   HashMap<String, Vertex> map = new HashMap<>();

    private   LinkedList<Pair<String,Arc>> ve = new LinkedList<>();

    public void makeMap(){

        long tiempoInicio=System.currentTimeMillis();
        final String fileName = "medellin_colombia-grande.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String ActualLine;
            ActualLine = br.readLine(); 
            while ((ActualLine = br.readLine()) != null) { 
                if (ActualLine.length() > 0) {
                    if (ActualLine.contains("Arco")) {
                        break;
                    }
                    String[] PartitionedString = ActualLine.split(" ", 4);

                    newVer(PartitionedString[0], Double.parseDouble(PartitionedString[1]),
                           Double.parseDouble(PartitionedString[2]));
                }
            }
            while ((ActualLine = br.readLine()) != null) { 
                if (!ActualLine.equals("")) {
                    String[] PartitionedString = ActualLine.split(" ", 4);

                    newArc(PartitionedString[0], PartitionedString[1],
                           Double.parseDouble(PartitionedString[2]));
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        long totalTiempo=System.currentTimeMillis()-tiempoInicio;
        System.out.println("Time read file: " + totalTiempo + "ms");
    }
    /**
     *
     * @param id
     * @param x
     * @param y
     */
    public void newVer(String id, double x, double y){
        Vertex vertex = new Vertex(id, x, y);
        map.put(vertex.getId(),vertex);

    }
    /**
     *
     * @param idFrom
     * @param idTo
     * @param dist
     *
     */
    public void newArc(String idFrom, String idTo, double distance){
        Arc arc = new Arc(idFrom,idTo,distance);
        map.get(arc.getId_1());
        addVe(arc.getId_2(),arc);

    }

    public void addVe(String idVe, Arc arc) {

        Pair pair = new Pair(idVe, arc);
        ve.add(pair);
    }
    /**
     * main method of the program 
     * @param args an array of arguments
     */

    public static void main(String[] args) {
        Point1 make = new Point1();
        make.makeMap();
        System.out.println("Elements added to the data structure");
    }
}
