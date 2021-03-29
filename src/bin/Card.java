package bin;

import java.util.*;

/*
    Clasa creata pentru gestionarea unui card
*/

public class Card{

    private String cardNumber;
    private Date expirationDate;
    private int CVV;
    private List<Account> accounts = new ArrayList<>();

    public Card(String _cardNumber, int _CVV){
        if(cardNumber.length() == 16)
            this.cardNumber = _cardNumber;
        if(_CVV >= 100 && _CVV <1000)
            this.CVV = _CVV;
        Account acc = new Account();
        accounts.add(acc);
        this.expirationDate = new Date(System.currentTimeMillis());
        expirationDate.setYear(expirationDate.getYear()+4);
    }

    public Card(){
        this.cardNumber = "0000000000000000";
        this.CVV = 0;
        this.expirationDate = new Date(System.currentTimeMillis());
        expirationDate.setYear(expirationDate.getYear()+4);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account){
        if(accounts.size() + 1 < 10 && account != null)
            if(!accounts.contains(account))
                accounts.add(account);
            else
                System.out.println("This account has been already added");
        else
            System.out.println("You can hold a maximum of 10 accounts on one card!");
    }

    public void printAccounts(){
        List<Account> l = this.getAccounts();
        for(int i = 0 ; i < l.size(); i++)
            l.get(i).AccountInfo();

    }

    public void closeAccount(Account account){
        for(Account a : accounts){
            if(a == account) {
                accounts.remove(a);
                break;
            }
        }
    }

    public void CardInfo(){
        if(cardNumber.length() == 16 && cardNumber != "0000000000000000")
            System.out.println(this.cardNumber);
        else
            System.out.println("Card number was not properly set!");
        if(CVV >= 100 && CVV <1000)
            System.out.println(this.CVV);
        else
            System.out.println("CVV was not properly set!");
        System.out.println(this.expirationDate);
    }

    public boolean isValid(){
        Date d = new Date(System.currentTimeMillis());
        return ((this.cardNumber != "0000000000000000" && this.cardNumber.length() == 16)
                && (this.CVV >= 100 && this.CVV <1000)
                && (!this.expirationDate.after(d)));
    }
}
