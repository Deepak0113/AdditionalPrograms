package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    private class Orange{
        int row;
        int col;
        int time;

        Orange(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private int orangesRotting(int[][] grid) {
        Queue<Orange> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int totalTime = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2)
                    queue.add(new Orange(i,j,0));
            }
        }

        while(!queue.isEmpty()){
            Orange orange = queue.remove();
            int row = orange.row;
            int col = orange.col;
            int time = orange.time;

            if(grid[row][col] != 2){
                grid[row][col] = 2;
                totalTime = time;
            }

            if(row-1>=0 && grid[row-1][col]==1)
                queue.add(new Orange(row-1, col, time+1));
            if(row+1<rows && grid[row+1][col]==1)
                queue.add(new Orange(row+1, col, time+1));
            if(col-1>=0 && grid[row][col-1]==1)
                queue.add(new Orange(row, col-1, time+1));
            if(col+1<cols && grid[row][col+1]==1)
                queue.add(new Orange(row, col+1, time+1));
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{};
        RottenOrange rottenOrange = new RottenOrange();
        System.out.print(rottenOrange.orangesRotting(grid));
    }
}
