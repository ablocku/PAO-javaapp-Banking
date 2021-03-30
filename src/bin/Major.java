package bin;

import java.util.ArrayList;
import java.util.List;

public class Major extends Person{
    List<Account> accountList = new ArrayList<>();
    List<Card> cardList = new ArrayList<>();


    public Major(int _age, String _firstName, String _lastName, char _gender){
            setAge(_age);
            super.setFirstName(_firstName);
            super.setLastName(_lastName);
            super.setGender(_gender);
    }

    @Override
    public void setAge(int age){
        if(ageisValid(age))
            super.setAge(age);
    }

    public Major(){
        this.setAge(18);
    }

    public Major(Major major){
        if(major.getAge() >= 18)
            new Major(major.getAge(),major.getFirstName(),major.getLastName(),major.getGender());
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

    @Override
    public boolean ageisValid(int age){
        if(age >= 18)
            return true;
        else
        {
            System.out.println("You cannot be a major if the age is lower than 18!");
            return false;
        }
    }

}
