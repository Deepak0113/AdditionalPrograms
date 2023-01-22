package consoleapp.ConsolePayment;

import java.util.*;

public class ConsoleAppPayment {
    private final LinkedHashMap<String, String> menu = new LinkedHashMap<>(){{
        this.put("11", "Pay to number");
        this.put("13", "Recharge");
        this.put("14", "donate");
        this.put("15", "Check my balance");
        this.put("19", "Back");
        this.put("10", "Exit");

        this.put("131", "₹666 1.5GB/day Data for 84 Days Pack");
        this.put("132", "₹239 1.5GB/day Data for 28 Days Pack");
        this.put("133", "₹65 for Existing 4GB Data Pack");
        this.put("134", "₹99 ₹99 Talk-time with 200MB Data Combo Pack");
        this.put("139", "Back");
        this.put("130", "Exit");

        this.put("141", "Charity1");
        this.put("142", "Charity2");
        this.put("149", "Back");
        this.put("140", "Exit");
    }};
    private User user;
    private final Stack<String> stack = new Stack<>();
    private final Scanner sc = new Scanner(System.in);

    public void startApp(){
        String option ;

        while(true) {
            if(stack.isEmpty()){
                startingMenu();
            } else{
                menuDisplay(stack.peek());
            }

            option = sc.nextLine();

            if (option.equals("0")) {
                stack.clear();
                user = null;
                break;
            }

            if (option.equals("9")) {
                stack.pop();
                if(stack.isEmpty()){
                    user = null;
                }
                continue;
            }

            if(stack.isEmpty()){
                Login();
                stack.push(option);
            } else if(menu.containsKey(stack.peek() + option)) {
                stack.push(stack.peek() + option);
                menuFunctionHandler(stack.peek());
            } else {
                System.out.println("Invalid option. Try selecting available option.");
            }
        }
        sc.close();
    }

    private void menuDisplay(String menuRoot){
        for(String key: menu.keySet()){
            if(key.length() == menuRoot.length()+1 && key.startsWith(menuRoot)){
                System.out.println(key.charAt(menuRoot.length())+" "+menu.get(key));
            }
        }
        System.out.print("Enter your option: ");
    }

    private void menuFunctionHandler(String key){
        if(key.equals("11")){
            phoneNumberPayment();
            stack.pop();
        } else if(key.equals("15")){
            System.out.println("Your balance: "+user.getBalance());
            stack.pop();
        } else if(key.startsWith("13") && key.length()==3){
            rechargePayment(key);
            stack.pop();
        } else if(key.startsWith("14") && key.length()==3){
            donationPayment(key);
            stack.pop();
        }
    }

    private void Login(){
        // gets name of the user
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        // gets phone number of the user
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        // gets account balance from the user
        System.out.print("Enter balance: ");
        float balance = Float.parseFloat(sc.nextLine());

        // create user object
        user = new User(name, phoneNumber, balance);
    }

    private void startingMenu(){
        System.out.println("Hi! How can I help you?");
        System.out.println("1. Login");
        System.out.println("0. Exit");
        System.out.print("Enter your option: ");
    }

    private void makeTransaction(float amount){
        // transaction confirmation
        System.out.print("Confirm Transaction "+amount+": Y/n");
        String ch = sc.nextLine();

        if(ch.equals("y") || ch.equals("Y")) {
            user.makeTransaction(amount);
            System.out.println("Transaction Completed!!");
        }
    }

    private void phoneNumberPayment(){
        // get phone number to make transaction to
        System.out.print("Phone number: ");
        String phoneNumber = sc.nextLine();

        // get transaction amount from the user
        System.out.print("Amount: ");
        float amount = Float.parseFloat(sc.nextLine());

        makeTransaction(amount);
    }

    private void rechargePayment(String key){
        String rechargeOption = menu.get(key);
        System.out.println(rechargeOption);
        float amount = Float.parseFloat(rechargeOption.substring(1,rechargeOption.indexOf(' ')));

        makeTransaction(amount);
    }

    private void donationPayment(String key){
        System.out.println(menu.get(key));
        System.out.print("Amount: ");
        float amount = Float.parseFloat(sc.nextLine());

        makeTransaction(amount);
    }
}