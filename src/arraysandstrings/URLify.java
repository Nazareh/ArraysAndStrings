/*Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
 */
package arraysandstrings;

/**
 *
 * @author Nazareh on 23-JAN-2018
 */
public class URLify {
    
    /*SolutionI solves the problem using the replace/trim  methods. 
      Although it might not be how the question wanted it implemented in the first place.*/
    public static String  prepareStringSolutionI(String s){
        return s.trim().replace(" ","20%");
    }
    /*SolutionII solves the problem using character array and without replace/trim methods.*/
    public static String  prepareStringSolutionII(String s){
        s = trimString(s);
        char[] letters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:letters) {
            if (c != ' ') {
                sb.append(c);
            }
            else {
                sb.append("20%");
            }
            
        }
     return sb.toString() ;
    }
    static String trimString(String s){
        char[] before = s.toCharArray();
        int start =0;
        int end = 0;
        //clear blank spaces at the begining
        for(int i = 0; i < before.length; i++){
            if (before[i] != ' ') {
                 start = i;
                 break;
            }
        }
        //clear blank spaces at the end
        for(int i = before.length-1; i > 0; i--){
            if (before[i] != ' ') {
                 end = i;
                 break;
            }
        }
        //adds the string without leading and trailing blanks to a new char[]
        char[] after = new char[end-start+1];
        int a = 0;
        for(int i = start; i <= end; i++){
            after[a] = before[i];
            a++;
        }
        return String.valueOf(after);
    }
    /* SolutionIII first scan and count the number of spaces. By tripling this
    number, it can compute how many extra characters we will have in the final 
    string. In the second pass, which is done in reverse order, it edits the 
    string. When it sees a space, replaces it with %20. If there is no space, 
    then it copies the original character. */
    static String prepareStringSolutionIII(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;
        int i = 0;
        for(i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        
        if (trueLength < str.length) 
            str[trueLength] = '\0';
        
        char[] strReturn =  new char[index];
        for (i = trueLength - 1; i >= 0; i-- ) {
            if (str[i] == ' ') {
                strReturn[index - 1]   = '0';
                strReturn[index - 2] = '2';
                strReturn[index - 3] = '%';
                index = index - 3;
                } 
            else {
                strReturn[index - 1] = str[i];
                index--;
                }
            }
        return String.valueOf(strReturn);
    }
    public static void main (String[] args) {
        String s = " Mr John Smith ";
        
        System.out.println(prepareStringSolutionI(s));
        System.out.println(prepareStringSolutionII(s));
        System.out.println(prepareStringSolutionIII(s.toCharArray(),13));
    }
    
    
}
