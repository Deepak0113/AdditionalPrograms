package consoleapp.ConsolePayment;

public class User {
    private final String name;
    private String phoneNumber;
    private float balance = 10000.00f;

    User(String name, String phoneNumber, float balance){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void makeTransaction(float amount){
        balance -= amount;
    }

    public float getBalance(){
        return balance;
    }
}
