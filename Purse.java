
//Required class for Map and HashMap

import java.util.LinkedHashMap;
import java.util.Map;

//Class to hold amounts of denominations

//cash Map - to hold type of denomination and amount of that denomination
//void add - add denomination and amount to purse
//double remove - remove amount of denomination from purse and return new value
//double getValue() -
//String purseToString() - return a string version of the Purse object. Renamed to avoid hierarchy issues with Object class.

public class Purse {

    Map<Denomination, Integer> cash = new LinkedHashMap<>(); //converted from HashMap to LinkedHashMap from project specs to preserve order of denominations

    void add (Denomination type, int num) {

        if(num<0) {num = 0;}    //catch any negative values

        if(cash.containsKey(type)) {
            cash.put(type, (cash.get(type)+num)); //if denomination is already in purse, add number of additional bills to existing number
        }

        else{
            cash.put(type, num);    //if denomination not in purse, add denomination and number of bills.
        }
    }

    double remove (Denomination type, int num) {

        if (cash.containsKey(type)) {   //only execute if type of denomination is in the purse
            if (cash.get(type) <= num) { //if number of bills to be removed is greater or equal to the amount available, remove type from cash map
                cash.remove(type);
            }
            else {
                cash.put(type, (cash.get(type) - num)); //remove number of bills from given type
            }
        }
        return getValue(); //return the current value of purse.
    }

    double getValue() {

        double value = 0;

        for(Map.Entry<Denomination, Integer> bill: cash.entrySet()){     //increments through this purse's cash Map one at a time

            value += (bill.getKey().amt())*(bill.getValue());   //takes this entry's cash value and multiplies it by the amount of that bill, then adds it to value
        }

        return value;
    }

    String purseToString() {
        StringBuilder purseContents = new StringBuilder();

        for(Map.Entry<Denomination, Integer> bill: cash.entrySet()) {     //increment through cash Map to create String object of purse contents that can be printed
            purseContents .append( bill.getValue() ) .append(" ") .append( bill.getKey().name() ) .append(" ") .append( bill.getKey().form() ) .append( bill.getValue() > 1 ? "s" : "" ) .append('\n');
            // [Value] [Denomination Name] [Denomination Form](s) newline
            // ex) 1 One-Dollar Bill
            //     4 Five-Dollar Bills
        }

        if (purseContents.isEmpty()) {
            purseContents.append("Empty Purse");}

        return purseContents.toString();
    }
}
