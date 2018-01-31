/*
 * IsUnique is a algorithm to determine if a string has all unique characters.
 */
package arraysandstrings;
import java.util.Arrays;

/**
 * @author Nazareh on 21-JAN-2018
 */
public class IsUnique {
    
    /*SolutionI gets each character of the String and check if they appear again in the String
    * they appear again in the String, using indexOf function. */
    public static boolean checkStringSolutionI(String str ) {
       
        char c;
        int idx = -1;
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            idx = str.indexOf(c, i+1);
            if (idx>=0) {
                return false;
            }
        }
        return true;
    } 
    /*SolutionII gets each character of the String and check if they appear again in the String
    * they appear again in the String iterating through a second loop*/
    public static boolean checkStringSolutionII(String str ) {
        char outter;
        char inner;
        for (int i = 0; i < str.length(); i++){
            outter = str.charAt(i);
            for (int j = 0; j < str.length(); j++){
             if (i != j && str.charAt(i) ==str.charAt(j)){
                 return false;
             }
            }
        }
        return true;
    } 
    /*SolutionIII considering that the input is ASCII.*/
    public static boolean checkStringSolutionIII(String str ) {

 
        boolean[] unique = new boolean[128];
       
        for (int i = 0; i < str.length(); i++){
            if (unique[str.charAt(i)] == false) {
                unique[str.charAt(i)] = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
     public static boolean checkStringSolutionIV(String str ) {
        /*SOlutionIV orders the string characters and check if 
         neighbours are equal.
         */
        char[] charArray =  str.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0 ; i < charArray.length -1; i++){
            if (charArray[i] == charArray[i+1]){
                return false;
            }
        }
        return true;
    }
 public static void main (String[] args){
      System.out.println(checkStringSolutionIV("abcHdfghj"));
 }
    
}
