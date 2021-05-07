package bin;

import java.util.Arrays;
import java.util.Date;



/*
    Clasa creata pentru organizarea contului unui utilizator
    Constructori : de initializare si de copiere
    Gettere si settere pentru toti membrii clasei
    Validari pentru toti membri clasei
*/

public class Account {

    private String IBAN; // IBAN-ul contului
    private String currency; // Valuta contului
    private double balance; // Suma curenta din cont
    private final Date createDate; // Data ultimei modificari aduse contului


    public Account(String _IBAN, String _currency){

        setIBAN(_IBAN);
        setCurrency(_currency);
        setBalance();
        this.createDate = new Date(System.currentTimeMillis());
    }

    public Account(){
        this.IBAN = "XX00XX12345678912345";
        this.currency = "RON";
        this.balance = 0;
        this.createDate = new Date(System.currentTimeMillis());
    }

    public Account(Account acc){
        this.IBAN = acc.IBAN;
        this.currency = acc.currency;
        this.balance = acc.balance;
        // Data contului este data la care s-a efectuat ultima modificare,
        this.createDate = new Date(System.currentTimeMillis());
    }

    public void setIBAN(String _IBAN){
        if(checkIBAN(_IBAN))
            this.IBAN = _IBAN;
        else
            this.IBAN = "XX00XXXX00000000000000";
    }

    public String getIBAN(){
        return this.IBAN;
    }

    // verifica daca IBAN dat este valid
    private boolean checkIBAN(String _IBAN){
        if(_IBAN.length() != 22 ){
            System.out.println("IBAN length should be 22 characters");
            return false;
        }
        return !_IBAN.equals("XX00XXXX00000000000000");
    }


    public void setCurrency(String _currency){
        if(checkCurrency(_currency))
            this.currency = _currency;
    }

    public String getCurrency(){
        return this.currency;
    }

    private boolean checkCurrency(String _currency){
        if(_currency.equals("RON") || _currency.equals("EUR") || _currency.equals("USD") || _currency.equals("GBP")){
            return true;
        }
        else {
            System.out.println("Set currency as RON/EUR/USD or GBP!");
            return false;
        }
    }

    private void setBalance(){
        this.balance = 0;
    }


    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double amount){ this.balance = amount;}

    public Date getCreateDate(){
        return this.createDate;
    }

    public boolean isValid(){
        if(this.IBAN.equals("XX00XXXX00000000000000") || this.IBAN.length() != 22)
            return false;
        if(this.currency.equals("RON") || this.currency.equals("EUR") ||  this.currency.equals("USD") ||  this.currency.equals("GBP"))
            ;
        else
            return false;
        if(this.balance < 0 )
            return false;
        return true;
    }

    // afiseaza informatii despre un cont
    public void AccountInfo(){
        System.out.println("IBAN: " + this.IBAN);
        System.out.println("Account currency: " + this.currency);
        System.out.println("Balance: " + this.balance);
        System.out.println("Created: " + this.createDate);
        if(checkIBAN(this.IBAN))
            System.out.println("IBAN VALIDITY: " + "verified" );
        else
            System.out.println("IBAN not valid!");
        if(checkCurrency(this.currency))
            System.out.println("Currency VALIDITY: " + "verified" );
        else
            System.out.println("Currency not valid!");
    }

    public void deposit(double sum){
        if(sum > 0) {
            double currBalance = this.getBalance();
            this.setBalance(currBalance + sum);
        }
        else
            System.out.println("Please select a valid sum!");
    }

    public void withdraw(double sum){
        double currBalance = this.getBalance();
        if(currBalance - sum >= 0){
            currBalance -= sum;
        }
        else
            System.out.println("Insufficient funds!");
    }
    
    public String convert2CSV(){
        StringBuilder s =  new StringBuilder("Account: ");
        s.append(IBAN).append(";");
        s.append(currency).append(";");
        s.append(balance).append(";");
        s.append(createDate).append(";");
        return s.toString();
    }

    @Override
    public String toString(){
        return "Account{" + "IBAN=" + IBAN + ",currency=" + currency + ",balance=" + balance + ",created=" + createDate+"}";
    }
}
