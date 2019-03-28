/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller9;

/**
 *
 * @author cl18417
 */
public class Taller9 {

    private static int LevenshteinDistance(String a, String b) {
        int[][] matriz = new int[a.length()+1][b.length()+1];
        for (int i = 1; i < matriz.length; i++) matriz[i][0] = i;
        for (int j = 1; j < matriz[0].length; j++) matriz[0][j] = j;
        for (int j = 1; j < b.length(); j++) {
            for (int i = 1; i < a.length(); i++) {
                if(a.charAt(i)==b.charAt(j)) {
                    matriz[i][j] = matriz[i-1][j-1];
                } else {
                    matriz[i][j] = Math.min(matriz[i-1][j]+1, Math.min(matriz[i][j-1]+1, matriz[i-1][j-1]+1));
                }
            }
        }
        return matriz[a.length()-1][b.length()-1];
    }
            
    public static void main(String[] args) {
        System.out.println(LevenshteinDistance("abc", "abdd"));
    }
    
}
