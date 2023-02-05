package leetcode;

import java.util.Arrays;

public class PermutationInString {
    private boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        if(s1len > s2len) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        int left=0, right=0;
        while(right<s1len){
            map1[s1.charAt(right)-'a']++;
            map2[s2.charAt(right)-'a']++;
            right++;
        }
        right--;

        while(right<s2len){
            if(Arrays.equals(map1,map2)) return true;
            right++;
            if(right < s2len){
                map2[s2.charAt(right)-'a']++;
            }
            map2[s2.charAt(left)-'a']--;
            left++;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.print(permutationInString.checkInclusion("ab", "eidbaooo"));
    }
}
