package bin;

/*
    Clasa unde un utilizator isi poate deschide un "buzunar"
    unde nu poate depune mai mult decat o suma stabilita de utilizator.
 */

public class Pocket extends Account{
    private int maxAmount = 0;

    public Pocket() {
        System.out.println("Pocket created, set the maximum amount for a deposit");
    };

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }
}
