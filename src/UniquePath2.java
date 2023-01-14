import java.util.Arrays;

public class UniquePath2 {
    static int recursion(int i, int j, int m, int n, int[][] ipGrid, int[][] grid)
    {
        if(j==n || i==m)
            return 0;
        if(ipGrid[i][j] == 1)
            return 0;
        if(j==n-1 && i==m-1)
            return 1;
        if(grid[i][j]!=-1)
            return grid[i][j];

        int val1 = recursion(i, j+1, m, n, ipGrid, grid);
        int val2 = recursion(i+1, j, m, n, ipGrid, grid);
        return grid[i][j]=val1+val2;
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] grid = new int[rows][cols];
        for(int[]a:grid)
            Arrays.fill(a,-1);

        return recursion(0,0,rows,cols,obstacleGrid,grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
