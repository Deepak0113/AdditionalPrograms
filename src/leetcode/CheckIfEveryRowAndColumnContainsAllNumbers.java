package leetcode;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
    private boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        int[] rowMap;
        int[] colMap;

        for(int i=0; i<n; i++){
            rowMap = new int[n];
            colMap = new int[n];
            for(int j=0; j<n; j++){
                if(rowMap[matrix[i][j]-1]==1 || colMap[matrix[j][i]-1]==1) return false;
                rowMap[matrix[i][j]-1] = 1;
                colMap[matrix[j][i]-1] = 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfEveryRowAndColumnContainsAllNumbers obj = new CheckIfEveryRowAndColumnContainsAllNumbers();
        int[][] matrix = new int[][]{{1,2,3},{3,1,2},{2,3,1}};
        System.out.print(obj.checkValid(matrix));
    }
}
