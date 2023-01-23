package consoleapp.ConsolePayment;

import consoleapp.Validation;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    /**
     * get phone number from the user. After validation, it returns as a String
     * @return String
     * */
    public static String getPhoneNumber(){
        while(true){
            System.out.print("Get Phone number: ");
            String phno = sc.nextLine();

            if(Validation.validatePhoneNumber(phno)){
                return phno;
            } else{
                System.out.println("Invalid phone number. Pls enter correct phone number");
            }
        }
    }

    /***
     * get amount from the user. After validation, it returns as a float
     * @return float
     */
    public static Float getAmount(){
        while(true){
            System.out.print("Amount: ");
            float amount = sc.nextFloat();

            if(Validation.validateAmount(amount)){
                return amount;
            } else{
                System.out.println("Amount cannot be negative");
            }
        }
    }
}
