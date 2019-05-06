public class Punto1_3 {

    public static int lcs ( int i , int j , String s1 , String s2 ) {
         if ( i == 0 || j == 0 ) {
             return 0 ;
             }
         boolean prev = i < s1.length() && j < s2.length();

         if( prev && s1.charAt(i) == s2.charAt(j)) {
             return 1 + lcs(i-1 ,j-1, s1 , s2 ) ;
             }
         int ni = lcs ( i-1 , j , s1 , s2 ) ;
         int nj = lcs ( i , j-1 , s1 , s2 ) ;
         return Math . max(ni, nj) ;
    }

    public static int lcs ( String s1 , String s2 ) {
         return lcs ( s1.length(), s2.length(), s1 , s2 ) ;
    }

}
