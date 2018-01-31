/*  
* Given two strings, the method should decide if one is a permutation of the other.
*/
package arraysandstrings;
import java.util.Arrays;

/**
 *
 * @author Nazareh created oin 23-JAN-2018
*/
public class CheckPermutation {
    static boolean firstCall = true;
    
    //SolutionI uses Arrays to first sort the letters and compare them;
    public static boolean checkPermutationSolutionI(String str1, String str2) {
        
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }
       
    static String sort(String s) {
           char[] c = s.toCharArray();
           Arrays.sort(c);
           return new String(c);
           
       }
    //SolutionII counts each letter on the String and then compare the quantities.
     public static boolean checkPermutationSolutionII(String str1, String str2) {
         
        if (str1.length() != str2.length()) {
            return false;
        }
        //Assuming that the inputs are ASCII, which contains 128 distinct characters.
        int[] charCounter = new int[128];
        
        //+1 for each character on STR1 and -1 for each character on STR2
        
        for(int i = 0; i < str1.length(); i++){
            charCounter[str1.charAt(i)]++;
            charCounter[str2.charAt(i)]--;
        } 
        
        //If any of the positions is left with a sum <> 0, they permutation is false. */
        for(int i = 0; i < str1.length(); i++) {
            if (charCounter[str1.charAt(i)] != 0){
                return false;
            }
        }
        
         return true;
    }
    public static void main (String[] args) {
        System.out.println(checkPermutationSolutionI("god", "dog"));
        System.out.println(checkPermutationSolutionII("nbcpoaa", "apncboa"));
        
    }
    
}
