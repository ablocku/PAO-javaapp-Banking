package bin;



public class Client extends Major {

    Bank b;

    public Client(int age, String firstName, String lastName, char gender,Account account, Card card){
        super(age,firstName,lastName,gender);
        if(account.isValid())
            if(!accountList.contains(account))
                this.accountList.add(account);
        if(card.isValid())
            if(!cardList.contains(card))
                this.cardList.add(card);
    }

    public Client(){
        super();
    }

    public Client(Client client){
        super(client);
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



    public void ClientInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("--- Accounts ---");
        for(Account a : accountList)
            a.AccountInfo();
        System.out.println("--- Cards ---");
        for(Card c: cardList)
            c.CardInfo();
    }

    public void setB(Bank b) {
        if(b != null) {
            this.b = b;
            b.getClientList().add(this);
        }
    }

    public String convert2CSV(){
        StringBuilder s = new StringBuilder("Client: ");
        s.append(getAge()).append(";");
        s.append(getName()).append(";");
        s.append(getGender()).append(";");
        for(int i = 0; i < getAccountList().size(); i = i+1)
            s.append(getAccountList().get(i)).append(";");

        for(int i = 0; i < getCardList().size(); i = i+1)
            s.append(getCardList().get(i)).append(";");
        return s.toString();
    }

    @Override
    public String toString(){
        return "Client{" + "age=" + getAge() + ",name=" + getName() + ",gender=" + getGender() + ",accountList=" + accountList.toString() + ",cardList=" + cardList.toString() + "}";
    }
}
