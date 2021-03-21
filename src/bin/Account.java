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
        if(checkIBAN(_IBAN))
            setIBAN(_IBAN);
        if(checkCurrency(_currency))
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
    }

    public String getIBAN(){
        return this.IBAN;
    }

    // verifica daca IBAN dat este valid
    private boolean checkIBAN(String _IBAN){
        if(_IBAN.length() != 22)
            return false;

        String s = "";
        String l = Arrays.toString(s.toCharArray());
        for(int i = 4; i < _IBAN.length(); ++i){
            s = s + l.charAt(i);
        }
        for(int i = 0; i < 4; ++i){
            s = s + l.charAt(i);
        }

        return checksum(s);
    }

    // functie de convert pentru validitatea IBAN
    private long convertToInteger(String l, int start, int end){
        long sum = 0;
        for(int i = start; i < end; ++i) {
            char c = l.charAt(i);
            if(c >= 'a' && c <= 'z'){
                sum = sum*10 + (long) (c-'a'+1);
            }
            else if(c >= 'A' && c <= 'Z'){
                sum += sum*10 + (long) (c-'A'+1);
            }
            else sum += sum*10 + (long)(c-'0');
        }
        return sum;
    }

    // operatie modulo pe IBAN convertit
    private boolean checksum(String _IBAN){

        int i = 0;
        String c = _IBAN;
        long x = 0;
        while(c.length() >= 7 ){
            x = convertToInteger(c,i,i+9);
            x = x %97;
            String nextTwo = String.valueOf(x);
            c = (new StringBuilder()).append(nextTwo).append(_IBAN,i+9,i+7).toString();
            i += 7;
        }
        if(c.length() >= 1) {
            x = convertToInteger(c, i, c.length() - 1);
            x = x % 97;
        }
        return x == 1;
    }

    public void setCurrency(String _currency){
        if(checkCurrency(_currency))
            this.currency = _currency;
    }

    public String getCurrency(){
        return this.currency;
    }

    private boolean checkCurrency(String _currency){
        return (_currency.equals("RON") || _currency.equals("EUR") || _currency.equals("USD") || _currency.equals("GBP"));
    }

    private void setBalance(){
        this.balance = 0;
    }

    public void setBalance(double sum){
        if(sum > 0)
            balance += sum;
    }

    public double getBalance(){
        return this.balance;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    // afiseaza informatii despre un cont
    public void AccountInfo(){
        System.out.println("IBAN: " + this.IBAN);
        System.out.println("Account currency: " + this.currency);
        System.out.println("Balance: " + this.balance);
        System.out.println("Created: " + this.createDate);
    }
}
