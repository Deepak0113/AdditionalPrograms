package leetcode;

public class NumberOfIslands {
    private void island(char[][] grid, int x, int y, int rows, int cols){
        grid[x][y] = '0';

        if(x+1 < rows && grid[x+1][y]=='1') island(grid, x+1, y, rows, cols);
        if(y+1 < cols && grid[x][y+1]=='1') island(grid, x, y+1, rows, cols);
        if(y-1 >= 0 && grid[x][y-1]=='1') island(grid, x, y-1, rows, cols);
        if(x-1 >= 0 && grid[x-1][y]=='1') island(grid, x-1, y, rows, cols);
    }

    private int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    island(grid, i, j, rows, cols);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.print(numberOfIslands.numIslands(grid));
    }
}
