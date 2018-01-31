package arraysandstrings;

/*
String Rotation:Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */

/**
 * @author Nazareh created on 29-JAN-2018
 */
public class StringRotation {
    
    public static boolean isSubstring(String s1, String s2){
        //Assuming the method  exists and does the proper checkings.
        return true;
        
    }
    public static boolean rotationCheck (String s1, String s2){
        if (isSubstring(s1,s2) == false || s1.length() != s2.length()) {return false;}
            
        int s1Length = s1.length();
        boolean exit = false;
        int s1Pos = 0;
        int s2Pos = 0;
        int equalChars = 0;
        while (exit == false)
        {
            if (s1.charAt(s1Pos) == s2.charAt(s2Pos)) {
                equalChars++;
                s1Pos++;
               
                if (equalChars == s1.length()){
                    return true;
                }
                else if (s1Pos == s1.length()) {
                    return false;
                }
            }
            else if (equalChars > 0) {
                equalChars = 0;
            }
            if (s2Pos+1 == s2.length()){
                s2Pos = -1;
            }
                s2Pos++;
        }
        return false;
    }
    public static void main (String[] args){
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(rotationCheck(s1,s2));
    }
}
