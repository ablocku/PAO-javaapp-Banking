import bin.*;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void Menu(){
        System.out.println("1) Add a bank");
        System.out.println("2) List all banks");
        System.out.println("3) Add a client");
        System.out.println("4) List all clients");
        System.out.println("5) Add a pocket");
        System.out.println("6) List all pockets");
        System.out.println("7) Add an account");
        System.out.println("8) List all accounts");
        System.out.println("9) Add a card");
        System.out.println("10) List all cards");
        System.out.println("11) Add a Visa card");
        System.out.println("12) List all Visa cards");
        System.out.println("13) Add a MasterCard card");
        System.out.println("14) List all MasterCard cards");
        System.out.println("15) Add a major");
        System.out.println("16) List all majors");
        System.out.println("0) Exit menu");
    }

    public static void main(String[] args) {

        int sel = -1;
        Scanner scanner = new Scanner(System.in);
        while(sel != 0){
            Menu();
            sel = scanner.nextInt();
            switch (sel){
                case 1:
                    SVC.addBank();
                    break;
                case 2:{
                    SVC.listBanks();
                    break;
                }

                case 3:{
                    SVC.addClient();
                    break;
                }

                case 4:{
                    SVC.listClients();
                    break;
                }

                case 5:{
                    SVC.addPocket();
                    break;
                }

                case 6:{
                    SVC.listPockets();
                    break;
                }

                case 7:{
                    SVC.addAccount();
                    break;
                }

                case 8:{
                    SVC.listAccounts();
                    break;
                }

                case 9:{
                    SVC.addCard();
                    break;
                }

                case 10:{
                    SVC.listCards();
                    break;
                }

                case 11:{
                    SVC.addVisa();
                    break;
                }

                case 12:{
                    SVC.listVisas();
                    break;
                }

                case 13:{
                    SVC.addMasterCard();
                    break;
                }

                case 14:{
                    SVC.listMasterCards();
                    break;
                }

                case 15:{
                    SVC.addMajor();
                    break;
                }

                case 16:{
                    SVC.listMajors();
                    break;
                }


            }
        }


        /*//metode cont
        Account account = new Account("ROa1982731","RON");
        //account.AccountInfo();
        account.setIBAN("GB82WEST12345698765432");
        //account.AccountInfo();
        //account.deposit(12);


        //metode card
        Card card = new Card();
        card.setCardNumber("1234123412341234");
        card.setCVV(955);
        card.addAccount(account);
        //card.CardInfo();
        List<Account> l = card.getAccounts();

        account.AccountInfo();
        System.out.println(card.getAccounts().isEmpty());
        System.out.println(card.getAccounts().contains(account));
        card.printAccounts();
        card.closeAccount(account);
        System.out.println("dupa remove");
        card.printAccounts();
        System.out.println("incercam sa adaugam de 2 ori");
        card.addAccount(account);
        card.addAccount(account);
        card.printAccounts();

        // metode subclase mastercard si visa



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
        card2.CardInfo();*/




    }
}
