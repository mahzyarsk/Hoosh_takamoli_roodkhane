public class product {
    private  int[]  Interference ;
    private int Expiration_Date;
    private int Inventory;
    private int Value;


    public product(int[] interference, int expiration_Date, int inventory, int fitness) {
        Interference = interference;
        Expiration_Date = expiration_Date;
        Inventory = inventory;
        Value = fitness;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public int[] getInterference() {
        return Interference;
    }

    public void setInterference(int[] interference) {
        Interference = interference;
    }

    public int getExpiration_Date() {
        return Expiration_Date;
    }

    public void setExpiration_Date(int expiration_Date) {
        Expiration_Date = expiration_Date;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }
}
