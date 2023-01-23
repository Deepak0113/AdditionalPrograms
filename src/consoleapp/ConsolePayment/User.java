package consoleapp.ConsolePayment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User {
    private final String name;
    private String phoneNumber;
    private float balance = 10000.00f;
    private static Scanner sc = new Scanner(System.in);

    User(String name, String phoneNumber, float balance){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void makeTransaction(float amount){
        // transaction confirmation
        System.out.print("Confirm Transaction ₹"+amount+" Y/n: ");
        String ch = sc.nextLine();

        if(amount > balance){
            System.out.println("Transaction cancelled. Insufficient bank balance to make transaction");
            return;
        }

        if(ch.equals("y") || ch.equals("Y")) {
            balance -= amount;
            System.out.println("Transaction Completed!!");
        } else{
            System.out.println("Transaction Canceled!!");
        }
    }

    public float getBalance(){
        return balance;
    }
}
