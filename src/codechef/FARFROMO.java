package codechef;

import java.util.Scanner;

public class FARFROMO {
    static double getDistanceBtw2Points(int x1, int y1, int x2, int y2){
        double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int x1,y1,x2,y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            double d1 = getDistanceBtw2Points(0,0,x1,y1);
            double d2 = getDistanceBtw2Points(0,0,x2,y2);

            if(d1>d2){
                System.out.println("ALEX");
            } else if(d1<d2){
                System.out.println("BOB");
            } else{
                System.out.println("EQUAL");
            }
        }
    }
}
