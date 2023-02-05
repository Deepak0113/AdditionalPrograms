package leetcode;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int startRow =0;
        int endRow = matrix.length;
        int startCol =0;
        int endCol = matrix[0].length;

        while(startRow < endRow || startCol < endCol){
            if(startRow < endRow){
                for(int i=startCol; i<endCol; i++){
                    res.add(matrix[startRow][i]);
                }
                startRow++;
            }

            if(endCol > startCol){
                for(int i=startRow; i<endRow; i++){
                    res.add(matrix[i][endCol-1]);
                }
                endCol--;
            }

            if(endRow > startRow){
                for(int i=endCol-1; i>=startCol; i--){
                    res.add(matrix[endRow-1][i]);
                }
                endRow--;
            }

            if(startCol < endCol){
                for(int i=endRow-1; i>=startRow; i--){
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.print(spiralMatrix.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
