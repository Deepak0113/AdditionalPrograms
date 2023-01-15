package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ARRSWAP {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt(), val;
            int max1=0, max2=0;
            int min1=Integer.MIN_VALUE, min2=Integer.MIN_VALUE;

            for(int i=0; i<n; i++){
                val = sc.nextInt();
                if(max1<val) max1 = val;
                if(min1>val) min1 = val;
            }

            for(int i=0; i<n; i++){
                val = sc.nextInt();
                if(max2<val) max2 = val;
                if(min2>val) min2 = val;
            }
        }
    }
}
