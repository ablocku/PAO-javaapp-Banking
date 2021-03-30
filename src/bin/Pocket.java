package bin;

/*
    Clasa unde un utilizator isi poate deschide un "buzunar"
    unde nu poate depune mai mult decat o suma stabilita de utilizator.
 */

public class Pocket extends Account{
    private double maxAmount = 0;
    private Account linkedAccount;

    public Pocket() {
        System.out.println("Pocket created, set the maximum amount for a deposit");
        linkedAccount = new Account();
    };

    public Pocket(Pocket p){
        this.maxAmount = p.maxAmount;
        this.linkedAccount = p.linkedAccount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        if(maxamountisValid(maxAmount))
            this.maxAmount = maxAmount;
    }

    public void setLinkedAccount(Account a){ this.linkedAccount = new Account(a);}

    public Account getLinkedAccount(){  return this.linkedAccount;}

    public void erasePocket(){
        if(linkedAccount.isValid()){
            linkedAccount.deposit(this.getBalance());
            this.linkedAccount = null;
            this.maxAmount = 0;
        }
    }

    @Override
    public void deposit(double sum){
        if(sum < maxAmount)
            super.deposit(sum);
    }

    public boolean maxamountisValid(int amount){
        if(amount <= 0){
            System.out.println("Set a larger amount");
            return false;
        }
        return true;
    }
}
