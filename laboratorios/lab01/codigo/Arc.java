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

public class Arc {
    String id_1;
    String id_2;
    String dest;

    public Arc(String id_1, String id_2, double distance) {
        this.id_1 = id_1;
        this.id_2 = id_2;
        this.dest = dest;
    }

    public String getId_1() {
        return id_1;
    }

    public void setId_1(String id_1) {
        this.id_1 = id_1;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
