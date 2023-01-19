package leetcode;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(dividend == Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;

        boolean sign = (dividend<0) ^ (divisor<0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient=0, count;

        while(dividend-divisor >= 0){
            count = 0;
            while(dividend-(divisor<<1<<count) >= 0){
                count++;
            }

//            System.out.print(dividend-(divisor<<1<<(count)));
//            System.out.println(" " + (dividend-(divisor*1<<count)));
            quotient += 1<<count;
            dividend = dividend - divisor*(1<<count);
        }

        return sign ? -quotient : quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
