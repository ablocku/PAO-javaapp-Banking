import bin.Account;
import bin.Card;

//de adaugat get in clasa card pt conturi si afisare

public class Main {
    public static void main(String args[]) {

        Account account = new Account("ROa1982731","RON");
        //account.AccountInfo();
        account.setIBAN("GB82WEST12345698765432");
        //account.AccountInfo();

        Card card = new Card();
        card.setCardNumber("1234123412341234");
        card.setCVV(955);
        card.addAccount(account);
        card.CardInfo();
    }
}
