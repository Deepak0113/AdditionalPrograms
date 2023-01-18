package leetcode;

public class MaxAreaofIsland {
    static int rec(int[][] grid, int x, int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length) return 0;

        grid[x][y] = 0;
        int count = 1;

        if(x-1>=0 && grid[x-1][y] == 1)
            count += rec(grid, x-1, y);
        if(x+1<grid.length && grid[x+1][y] == 1)
            count += rec(grid, x+1, y);
        if(y-1>=0 && grid[x][y-1] == 1)
            count += rec(grid, x, y-1);
        if(y+1<grid[0].length && grid[x][y+1] == 1)
            count += rec(grid, x, y+1);

        return count;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int val = rec(grid, i, j);
                    if(val > max) max = val;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
