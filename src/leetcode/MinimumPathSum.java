package leetcode;

public class MinimumPathSum {
    static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i+1 <= m-1 && j+1 <= n-1){
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                } else if(i+1 <= m-1){
                    grid[i][j] += grid[i+1][j];
                } else if(j+1 <= n-1){
                    grid[i][j] += grid[i][j+1];
                }
            }
        }

        return grid[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
