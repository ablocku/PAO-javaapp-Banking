package bin;

import java.util.*;


public class Card{

    private String cardNumber;
    private Date expirationDate;
    private int CVV;
    private List<Account> accounts = new List<Account>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Account> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Account account) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Account> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Account> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Account get(int index) {
            return null;
        }

        @Override
        public Account set(int index, Account element) {
            return null;
        }

        @Override
        public void add(int index, Account element) {

        }

        @Override
        public Account remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Account> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Account> listIterator(int index) {
            return null;
        }

        @Override
        public List<Account> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

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

    public void depositSum(double sum){
        if(sum > 0) {
            Account a = accounts.get(0);
            a.setBalance(sum);
            accounts.remove(0);
            accounts.add(0, a);
        }
    }
}
