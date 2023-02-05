package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    private List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        List<Integer> res = new ArrayList<>();

        if(plen > slen) return res;

        int[] smap = new int[26];
        int[] pmap = new int[26];

        int left=0, right=0;

        while(right<plen){
            pmap[p.charAt(right)-'a']++;
            smap[s.charAt(right)-'a']++;
            right++;
        }

        right--;

        while(right<slen){
            if(Arrays.equals(pmap, smap)){
                res.add(left);
            }

            right++;
            if(right < slen)
                smap[s.charAt(right)-'a']++;
            smap[s.charAt(left)-'a']--;
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("cbaebabacd","abc"));
    }
}
