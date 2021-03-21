package bin;

import java.util.Date;
import java.util.List;


public class Card{

    private String cardNumber;
    private Date expirationDate;
    private int CVV;
    private List<Account> accounts;

    public Card(String _cardNumber, int _CVV){
        if(cardNumber.length() == 16)
            this.cardNumber = _cardNumber;
        if(_CVV >= 100 && _CVV <1000)
            this.CVV = _CVV;
        Account acc = new Account();
        accounts.add(acc);
        this.expirationDate = acc.getCreateDate();
        expirationDate.setYear(expirationDate.getYear()+4);
    }

    public Card(){
        this.cardNumber = "0000000000000000";
        this.CVV = 0;
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
        if(accounts.size() + 1 < 10)
            accounts.add(account);
        else
            System.out.println("You can hold a maximum of 10 accounts on one card!");
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
        System.out.println(this.cardNumber);
        System.out.println(this.CVV);
        System.out.println(this.expirationDate);
    }

    public void depositSum(double sum){
        if(sum > 0) {
            Account a = accounts.get(0);
            a.setBalance(sum);
            accounts.remove(0);
            accounts.add(0, a);
        }
    }
}
