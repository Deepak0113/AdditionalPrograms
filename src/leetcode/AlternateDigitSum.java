package leetcode;

public class AlternateDigitSum {
    public static int alternateDigitSum(int n) {
        int count = 0;
        int res = 0;

        while(n!=0){
            if(count%2==0)
                res += n%10;
            else
                res -= n%10;
            n/=10;
            count++;
        }

        if(count%2==0) res = -res;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
    }
}
