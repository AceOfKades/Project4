//Class required for Scanner objects.
import java.util.*;

//Driver class
//Creates a purse object with a given amount and demonstrates that it works.

//Purse makeChange - creates a purse object that returns the amount given in minimum denomination
//public static void main - where the magic happens.

public class Register {
    private static Register instance;
    private ChangeStrategy strategy;

    private Register() {
        this.strategy = new StandardChangeStrategy(); // Default strategy
    }

    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

    public void setStrategy(ChangeStrategy strategy) {
        this.strategy = strategy;
    }

    public Purse makeChange(double amt) {
        return strategy.makeChange(amt);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an amount of money: ");

        double amt;

        try {
            amt = scanner.nextDouble();
        } catch (Exception e) {
            amt = 0.0;
        }

        Purse purse = Register.getInstance().makeChange(amt);

        System.out.println(purse.purseToString());
    }
}
