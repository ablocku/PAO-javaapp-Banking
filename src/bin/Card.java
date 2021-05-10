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
        setCardNumber(_cardNumber);
        setCVV(_CVV);
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
        if(cardnumberisValid(cardNumber))
            this.cardNumber = cardNumber;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        if(cvvisValid(CVV))
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
            System.out.println("Card number: " + this.cardNumber);
        else
            System.out.println("Card number was not properly set!");
        if(CVV >= 100 && CVV <1000)
            System.out.println("CVV: " + this.CVV);
        else
            System.out.println("CVV was not properly set!");
        System.out.println("Expiration Date: " + this.expirationDate);
        System.out.println();
    }

    public boolean isValid(){
        Date d = new Date(System.currentTimeMillis());
        return ((!this.cardNumber.equals("0000000000000000") && this.cardNumber.length() == 16)
                && (this.CVV >= 100 && this.CVV <1000));
                /*&& (!this.expirationDate.after(d)));*/
    }

    public boolean isdigit(char c){
        return c>='0' && c<='9';
    }

    public boolean cardnumberisValid(String cardNumber){
        if(cardNumber.length() != 16){
            System.out.println("Card number should be 16 characters long");
            return false;
        }
        for(int i = 0 ; i < cardNumber.length(); i++)
            if(!isdigit(cardNumber.charAt(i))){
                System.out.println("Only digits are allowed");
                return false;
            }
        return true;
    }

    public boolean cvvisValid(int CVV){
        if(CVV >= 100 && CVV <= 999)
            return true;
        else{
            System.out.println("Please enter a 3-digit number!");
            return false;
        }

    }

    public String convert2CSV(){
        StringBuilder s =  new StringBuilder("Card: ");
        s.append(cardNumber).append(";");
        s.append(expirationDate).append(";");
        s.append(CVV).append(";");
        s.append(accounts.size()).append(";");
        for(int i = 0; i < accounts.size(); i=i+1){
            s.append(accounts.get(i).convert2CSV()).append(";");
        }
        return s.toString();
    }

    @Override
    public String toString(){
        return "Card{" + "cardNumber=" + cardNumber + ",expirationDate=" + expirationDate + ",nrOfAccounts=" + accounts.size() +",CVV=" + CVV + ",accounts=" + accounts.toString() + "}";
    }

}
