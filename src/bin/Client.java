package bin;

import org.jetbrains.annotations.NotNull;

public class Client extends Major{

    public Client(int age, String firstName, String lastName, char gender,Account account, Card card){
        super(age,firstName,lastName,gender);
        if(account.isValid())
            if(!accountList.contains(account))
                this.accountList.add(account);
        if(card.isValid())
            if(!cardList.contains(card))
                this.cardList.add(card);
    }

    public void addAccount(Account account){
        if(account.isValid())
            if(!accountList.contains(account))
                this.accountList.add(account);
    }

    public void addCard(Card card){
        if(card.isValid())
            if(!cardList.contains(card))
                this.cardList.add(card);
    }


}
