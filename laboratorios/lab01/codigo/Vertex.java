/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.juancamiloguerreroalarcon.juanjoseescuderovalencia.santiagopulgarinvasquez;

/**
 *
 * @author jcguerrera && jjescuderv && spulgarinv
 */
public class Vertex {
    private String Id;
    private double x;
    private double y;

    public Vertex(String id, double x, double y) {
        Id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
