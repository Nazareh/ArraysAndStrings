/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package arraysandstrings;

/**
 * @author Nazareh created on 29-JAN-2018
 */
public class RotateMatrix {
    
    static int[][] initMatrix (int[][] matrix){
        int i = 1;
        System.out.println("---------Original Matrix-----------");
        for (int row = 0; row < matrix.length; row++ ) {
            for (int col = 0; col < matrix[row].length; col++){
                matrix[row][col] = i++;
                   System.out.print("["+matrix[row][col]+"]");
            }
            System.out.println();
        }
      return matrix;
    }
    
    public static int[][] createMatrix (int rows, int cols) {
       int[][] matrix = new int[rows][cols];
       return matrix;
    }
    public static int[][] rotateMatrix (int[][] matrix) {
  
        /*Swap the number of cols and rows. 
          For example, if the matrix 3x4, it would be 4x3 when rotated.*/
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        
        System.out.println("---------Rotated Matrix-----------");
        int newCol = 0;
        for (int newRow = 0; newRow < newMatrix.length ; newRow++ ){
            newCol = 0;
            for (int oldRow = matrix.length -1; oldRow>=0; oldRow--){
                newMatrix[newRow][newCol] = matrix[oldRow][newRow]; 
                System.out.print("["+    newMatrix[newRow][newCol]   +"]");
                newCol++;
            }
             System.out.println();
        }
        return newMatrix;
    }
   public static void main (String[] args){
       int rows = 3;
       int cols = 5;

       if (rows > 0 && cols > 0){
           int[][] matrix = rotateMatrix(initMatrix(createMatrix(rows,cols))); //90 degrees
           matrix = rotateMatrix(matrix);//180 degrees
           matrix = rotateMatrix(matrix);//240 degrees
           matrix = rotateMatrix(matrix);//360 degrees
        }
   }
}
