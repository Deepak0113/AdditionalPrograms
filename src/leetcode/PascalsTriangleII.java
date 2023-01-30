package leetcode;

import java.util.List;
import java.util.Arrays;

public class PascalsTriangleII {
    private List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        Arrays.fill(res, 0);
        res[0] = 1;

        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>0; j--){
                res[j] += res[j-1];
            }
        }

        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        PascalsTriangleII pt2 = new PascalsTriangleII();
        int n = 5;
        for(Integer item: pt2.getRow(n)){
            System.out.print(item+" ");
        }
    }
}
