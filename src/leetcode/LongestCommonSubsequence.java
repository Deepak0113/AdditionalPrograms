package leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int lcs(String str1, String str2, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j))
            return dp[i][j] = 1 + lcs(str1,str2,i-1,j-1, dp);
        return dp[i][j] = 0 + Math.max(lcs(str1,str2,i-1,j, dp), lcs(str1,str2,i,j-1,dp));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return lcs(text1, text2, n-1, m-1, dp);
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
