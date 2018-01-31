/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false.
 */

package arraysandstrings;
/**
 * @author Nazareh created on 24-JAN-2018
 */
import java.util.Map;

public class OneAway {
    
    public static boolean isOneAway(String a, String b) {
        // the difference cannot be more then 1 character.
        if (Math.abs( a.length() - b.length()) > 1) {
            return false;
        }
        
        StringBuilder sbB = new StringBuilder(b);
        int idx = -1;
                for(int i = 0; i < a.length() ; i++){
                    idx = sbB.indexOf(a.substring(i, i+1));
                    if (idx != -1) {
                        sbB.deleteCharAt(idx);
                    }
                }
        return sbB.length() <= 1 ? true : false;
    }
    public static void main (String[] args){
        //Test 1 - remove 
        String a = "pale";
        String b = "ple";
        //test 2 - remove at the end
        a = "pales";
        b = "pale";
        System.out.println(isOneAway (a,b));
        //test 3 - replace at the beginning
        a = "pale";
        b = "bale";
        System.out.println(isOneAway (a,b));
        //test 4 - replace 2 letters
        a = "pale";
        b = "bake";
        System.out.println(isOneAway (a,b));
        //test 5 - insert 
        a = "pale";
        b = "pale";
        System.out.println(isOneAway (a,b));
   
    }
}
