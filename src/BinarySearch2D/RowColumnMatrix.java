package BinarySearch2D;

import java.util.Arrays;

public class RowColumnMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,8,9},
                {6,10,11},
                {7,13,14}
        };
        System.out.println(Arrays.toString(search(matrix,7)));
    }
    static int[] search(int[][] matrix, int target){
        // row and column values are for NxN matrix, but it can be adapted to different matrix variations
        int row = 0;
        int column = matrix.length - 1;

        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return new int[]{row,column};
            }

            if(matrix[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
