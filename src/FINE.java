import java.util.Scanner;

public class FINE{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), speed;

		while(t-->0){
			 speed = sc.nextInt();
			 if(speed<=70){
				 System.out.println(0);
			 } else if(speed>70 && speed<=100){
				 System.out.println(500);
			 } else{
				 System.out.println(2000);
			 }
		}
	}
}