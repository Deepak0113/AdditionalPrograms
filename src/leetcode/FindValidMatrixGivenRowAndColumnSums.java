package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindValidMatrixGivenRowAndColumnSums {
    private int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length, col = colSum.length, min;
        int[][] mat = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                min = Math.min(rowSum[i], colSum[j]);
                rowSum[i]-=min;
                colSum[j]-=min;
                mat[i][j]=min;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        FindValidMatrixGivenRowAndColumnSums validate = new FindValidMatrixGivenRowAndColumnSums();
        int[] rows = new int[]{3,8};
        int[] cols = new int[]{4,7};
        int[][] mat = validate.restoreMatrix(rows, cols);
        for(int[] row: mat){
            System.out.println(Arrays.toString(row));
        }
    }
}
