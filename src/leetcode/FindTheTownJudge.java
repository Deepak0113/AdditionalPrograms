package leetcode;

public class FindTheTownJudge {
    static public int findJudge(int n, int[][] trust) {
        int[] map = new int[n];
        int judge=-1, max=0;

        for(int[] relationship: trust){
            if(relationship[0] == relationship[1]){
                return -1;
            }

            map[relationship[0]-1]--;
            map[relationship[1]-1]++;
        }

        for(int i=0; i<n; i++){
            if(map[i] == n-1){
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{{1,3},{2,3}}));
    }
}
