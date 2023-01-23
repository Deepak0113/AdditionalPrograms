package consoleapp.ConsolePayment;

import consoleapp.Validation;

import java.util.*;

public class ConsoleAppPayment {
    private final LinkedHashMap<String, String> menu = new LinkedHashMap<>(){{
        this.put("11", "Pay to number");
        this.put("12", "Recharge");
        this.put("13", "donate");
        this.put("14", "Check my balance");
        this.put("19", "Back");
        this.put("10", "Exit");

        this.put("121", "₹666 1.5GB/day Data for 84 Days Pack");
        this.put("122", "₹239 1.5GB/day Data for 28 Days Pack");
        this.put("123", "₹65 for Existing 4GB Data Pack");
        this.put("124", "₹99 ₹99 Talk-time with 200MB Data Combo Pack");
        this.put("129", "Back");
        this.put("120", "Exit");

        this.put("131", "Charity1");
        this.put("132", "Charity2");
        this.put("139", "Back");
        this.put("130", "Exit");
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

            if(option.equals("1") && stack.isEmpty()){
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
        if(menu.get(menuRoot) == null)
            System.out.println("\nHome\n--------------------------------------");
        else
            System.out.println("\n"+menu.get(menuRoot)+"\n--------------------------------------");
        for(String key: menu.keySet()){
            if(key.length() == menuRoot.length()+1 && key.startsWith(menuRoot)){
                System.out.println(key.charAt(menuRoot.length())+" "+menu.get(key));
            }
        }
        System.out.print("Enter your option: ");
    }

    private void menuFunctionHandler(String key){
        if(key.equals("11")){
            System.out.println("\n"+menu.get(key)+"\n--------------------------------------");
            phoneNumberPayment();
            stack.pop();
        } else if(key.equals("14")){
            System.out.println("\n"+menu.get(key)+"\n--------------------------------------");
            System.out.println("Your balance: "+user.getBalance());
            stack.pop();
        } else if(key.startsWith("12") && key.length()==3){
            System.out.println("\n"+menu.get(key)+"\n--------------------------------------");
            rechargePayment(key);
            stack.pop();
        } else if(key.startsWith("13") && key.length()==3){
            System.out.println("\n"+menu.get(key)+"\n--------------------------------------");
            donationPayment(key);
            stack.pop();
        }
    }

    private void Login(){
        System.out.println("\nLogin\n--------------------------------------");

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

    private void phoneNumberPayment(){
        // get phone number to make transaction to
        String phoneNumber = Input.getPhoneNumber();

        // get transaction amount from the user
        float amount = Input.getAmount();

        // make transaction
        user.makeTransaction(amount);
    }

    private void rechargePayment(String key){
        String rechargeOption = menu.get(key);
        float amount = Float.parseFloat(rechargeOption.substring(1,rechargeOption.indexOf(' ')));
        if(Validation.validateAmount(amount)){
            user.makeTransaction(amount);
        } else {
            System.out.println("Invalid transaction. transaction canceled");
        }
    }

    private void donationPayment(String key){
        System.out.println(menu.get(key));

        // get transaction amount
        float amount = Input.getAmount();

        // make transaction
        user.makeTransaction(amount);
    }
}