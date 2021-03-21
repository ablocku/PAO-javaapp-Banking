package bin;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;


/*
    Clasa creata pentru organizarea contului unui utilizator
    Constructori : de initializare si de copiere
    Gettere si settere pentru toti membrii clasei
    Validari pentru toti membri clasei
    Metode pentru deposit si withdraw din cont
*/

public class Account {

    private String IBAN; // IBAN-ul contului
    private String currency; // Valuta contului
    private double balance; // Suma curenta din cont
    private Date createDate; // Data ultimei modificari aduse contului


    public Account(String _IBAN, String _currency){
        if(checkIBAN(_IBAN))
            this.IBAN = _IBAN;
        if(checkCurrency(_currency))
            this.currency = _currency;
        setBalance();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.createDate = date;
    }

    public Account(Account acc){
        this.IBAN = acc.IBAN;
        this.currency = acc.currency;
        this.balance = acc.balance;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z"); // Data contului este data la care s-a efectuat ultima modificare,
        Date date = new Date(System.currentTimeMillis()); // altfel, data nu as mai fi modificat-o
        this.createDate = date;
    }

    public void setIBAN(String _IBAN){
        if(checkIBAN(_IBAN))
            this.IBAN = _IBAN;
    }

    public String getIBAN(){
        return this.IBAN;
    }

    //checks if given iban is valid
    private boolean checkIBAN(String _IBAN){
        if(_IBAN.length() != 22)
            return false;

        String s = _IBAN;
        String l = Arrays.toString(s.toCharArray());
        for(int i = 4; i < _IBAN.length(); ++i){
            s = s + l.charAt(i);
        }
        for(int i = 0; i < 4; ++i){
            s = s + l.charAt(i);
        }


        return true;
    }

    //converts iban characters for the verifying algorithm
    private long convertToInteger(String l, int start, int end){
        long sum = 0, p = 1;
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

    //modulo operation on iban converted to long
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
        return (_currency == "RON" || _currency =="EUR" || _currency == "USD" || _currency == "GBP");
    }

    private void setBalance(){
        this.balance = 0;
    }

    public double getBalance(){
        return this.balance;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public void depositSum(double sum){
        if(sum > 0) {
            this.balance += sum;
            System.out.println("You have deposited " + toString(sum) + currency);
        }
    };

    public void withdrawSum(double sum){
        if(balance - sum > 0) {
            this.balance -= sum;
            System.out.println("You have withdrawn " + toString(sum) + currency);
        }
    };

}
