//Record for currency denominations

//String name - name of currency (Ten note, five note, nickel, penny, etc.)
//double amt - amount of money this currency represents
//String form - bill, coin, whatever physical form the currency takes
//String img - containing image name and path for use of currency

public record Denomination(String name, double amt, String form, String img) {}
