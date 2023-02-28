package BinarySearch2D;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(arr, 9)));
    }
    static int[] binarySearch(int[][] matrix, int row, int columnStart, int columnEnd, int target){
        while (columnStart <= columnEnd){
            int mid = columnStart + (columnEnd - columnStart) / 2;
            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
            if (matrix[row][mid] < target){
                columnStart = mid + 1;
            }else{
                columnEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int[][] matrix, int target){
        int row = matrix.length;
        int column = matrix[0].length;

        if(row == 1){
            return binarySearch(matrix,0,0,column-1,target);
        }

        int rowStart = 0;
        int rowEnd = row - 1;
        int midColumn = column / 2;

        while(rowStart < (rowEnd - 1)){
            int midRow = rowStart + (rowEnd - rowStart) / 2;
            if(matrix[midRow][midColumn] == target){
                return new int[]{midRow,midColumn};
            }
            if(matrix[midRow][midColumn] < target){
                rowStart = midRow;
            }else{
                rowEnd = midRow;
            }
        }

        if(matrix[rowStart][midColumn] == target){
            return new int[]{rowStart,rowEnd};
        }

        if(matrix[rowStart + 1][midColumn] == target){
            return new int[]{rowStart + 1,rowEnd};
        }

        if (target <= matrix[rowStart][midColumn - 1]) {
            return binarySearch(matrix, rowStart, 0, midColumn-1, target);
        }

        if (target >= matrix[rowStart][midColumn + 1] && target <= matrix[rowStart][column - 1]) {
            return binarySearch(matrix, rowStart, midColumn + 1, column - 1, target);
        }

        if (target <= matrix[rowStart + 1][midColumn - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, midColumn-1, target);
        } else {
            return binarySearch(matrix, rowStart + 1, midColumn + 1, column - 1, target);
        }
    }
}
