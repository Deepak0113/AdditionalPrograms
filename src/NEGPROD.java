import java.util.Scanner;

public class NEGPROD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), a, b, c;

        while(t-->0){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a*b<0 || b*c<0 || c*a<0){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
