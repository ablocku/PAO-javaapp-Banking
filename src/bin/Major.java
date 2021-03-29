package bin;

import java.util.ArrayList;
import java.util.List;

public class Major extends Person{
    List<Account> accountList = new ArrayList<>();
    List<Card> cardList = new ArrayList<>();


    public Major(int _age, String _firstName, String _lastName, char _gender){
        if(_age >= 18) {
            super.setAge(_age);
            super.setFirstName(_firstName);
            super.setLastName(_lastName);
            super.setGender(_gender);
        }
    }

    public Major(){
        this.setAge(18);
    }

    public void setAccountList(List<Account> accountList) {
        if(accountList.isEmpty())
            this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setCardList(List<Card> cardList) {
        if(cardList.isEmpty())
            this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

}
