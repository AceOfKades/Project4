import java.util.*;

public class StandardChangeStrategy implements ChangeStrategy {
    public Purse makeChange(double amt) {
        List<Denomination> denominations = List.of(
                new Denomination("One-Hundred-Dollar", 100.00, "Bill", "Images\\one_hundred_dollar.png"),
                new Denomination("Fifty-Dollar", 50.00, "Bill", "Images\\fifty_dollar.png"),
                new Denomination("Twenty-Dollar", 20.00, "Bill", "Images\\twenty_dollar.png"),
                new Denomination("Ten-Dollar", 10.00, "Bill", "Images\\ten_dollar.png"),
                new Denomination("Five-Dollar", 5.00, "Bill", "Images\\five_dollar.png"),
                new Denomination("One-Dollar", 1.00, "Bill", "Images\\one_dollar.png"),
                new Denomination("Quarter", 0.25, "Coin", "Images\\quarter.png"),
                new Denomination("Dime", 0.10, "Coin", "Images\\dime.png"),
                new Denomination("Nickel", 0.05, "Coin", "Images\\nickel.png"),
                new Denomination("Penny", 0.01, "Coin", "Images\\penny.png")
        );

        Purse purse = new Purse();

        for (Denomination denom : denominations) {
            amt = Math.round(100.0 * amt) / 100.0;
            int count = (int)(amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
            }
        }

        return purse;
    }
}
