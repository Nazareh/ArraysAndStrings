/*
Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)*/
package arraysandstrings;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Nazareh on 23-JAN-2018
 */
public class PalindromePermutation {
    
    //checks is a set of characters can be turned into palindrome words.
    public static boolean isPalindrome (String s){
        
        char[] letters = s.toCharArray();
        List<Character> counter = new ArrayList();
        
        for(char c:letters) {
            if (counter.contains(c)){
                 counter.remove(counter.indexOf(c));
            }
            else  {
                counter.add(c);
            }
        }
        return (counter.size() <= 1) ? true : false;
    }
    
    /*Method to create all possible permutations for a given word. */
    public static List<String> createPermutations(char[] current, int pos, List<String> permutations ){
        if (pos !=0) {   
            
            permutations.add(String.valueOf(current));
            char aux = current[pos-1];
            current[pos-1] = current[pos];
            current[pos] =  aux;
            
            if (permutations.size() != 1 &&
               (permutations.get(0).equals(permutations.get(permutations.size() -1)))) {
                
                    permutations.remove(permutations.size()-1);
                }
            else {
                createPermutations(current,pos-1,permutations);
            } 
        }
        else {
            createPermutations(current, current.length -1,permutations);
        }
        return permutations;
    }
    
    //Method removes all strings from the list that are no palindrome.
    public static List<String> filterPalindrome(List<String> array){
       StringBuilder sb;
       List<String> palindromeList = new ArrayList() ;
       for(int i = 0; i < array.size(); i++){
          sb = new StringBuilder(array.get(i));
              if (sb.toString().equals(sb.reverse().toString())){
                  palindromeList.add(array.get(i));
              }
        }
       return palindromeList;
    }
    public static void main (String[] args){
        String s = "Tact Coa";
        s = "anna";
      
        //check if the word is a palindrome, if so create all combinations of characters.
        if (isPalindrome(s)) {
            
            //creates the permutation list.
            List<String> palindPermuList = new ArrayList();
            createPermutations(s.toCharArray(), s.length()-1,palindPermuList);
            palindPermuList = filterPalindrome(palindPermuList);

            if (palindPermuList.size() > 0 ) {
               System.out.print("True (permutations: ");
                for(String str:palindPermuList){
                    System.out.print(str+ " ");
                }
                System.out.print(")");
            }
            else  {
                System.out.print("The word "+ s +" is not a palindrome permutation.");
            }
        }
        else {
            System.out.print("The word "+ s +" is not a palindrome permutation.");
        }
    }
}
