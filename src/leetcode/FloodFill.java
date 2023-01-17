package leetcode;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int temp = image[sr][sc];
        image[sr][sc] = color;

        if(sr>0 && image[sr-1][sc]==temp)
            image = floodFill(image, sr-1, sc, color);

        if(sr<image.length-1 && image[sr+1][sc]==temp)
            image = floodFill(image, sr+1, sc, color);
        if(sc>0 && image[sr][sc-1]==temp)
            image = floodFill(image, sr, sc-1, color);
        if(sc<image[0].length-1 && image[sr][sc+1]==temp)
            image = floodFill(image, sr, sc+1, color);

        return image;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        for(int[] arr: floodFill(mat,sr,sc,color)){
            System.out.println(Arrays.toString(arr));
        }
    }
}
