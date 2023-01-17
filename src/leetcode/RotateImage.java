package leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        int temp;

        for(int i=0; i<size; i++){
            for(int j=i; j<size-i-1; j++){
                temp = matrix[j][size-i-1];
                matrix[j][size-i-1] = matrix[i][j];
                matrix[i][j] = temp;

                temp = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[i][j];
                matrix[i][j] = temp;

                temp = matrix[size-j-1][i];
                matrix[size-j-1][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int[] arr: matrix)
            System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(mat);
    }
}
