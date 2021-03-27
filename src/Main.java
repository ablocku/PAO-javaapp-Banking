import bin.*;

import java.util.List;

//de adaugat get in clasa card pt conturi si afisare
// de verificat accountcontroller si de facut pocket

public class Main {
    public static void main(String[] args) {

        //metode cont
        Account account = new Account("ROa1982731","RON");
        //account.AccountInfo();
        account.setIBAN("GB82WEST12345698765432");
        //account.AccountInfo();
        //account.deposit(12);

/*
        //metode card
        Card card = new Card();
        card.setCardNumber("1234123412341234");
        card.setCVV(955);
        card.addAccount(account);
        //card.CardInfo();
        List<Account> l = card.getAccounts();
        /*
        account.AccountInfo();
        System.out.println(card.getAccounts().isEmpty());
        System.out.println(card.getAccounts().contains(account));
        card.printAccounts();
        metode subclase mastercard si visa
*/

/*
        Card card1 = new MasterCard();
        card1.CardInfo();
        card1.setCardNumber("123412341234"); // invalid number
        card1.setCVV(25); // invalid CVV
        card1.CardInfo();
        card1.setCardNumber("4321432143214321");
        card1.setCVV(621);
        card1.CardInfo();

        //----
        Card card2 = new Visa();
        card2.CardInfo();
        card2.setCVV(621);
        card2.setCVV(222); // ultimul CVV e 222
        card2.CardInfo();
*/

    }
}
