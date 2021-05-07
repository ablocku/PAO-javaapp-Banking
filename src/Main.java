import bin.*;

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
        SVC service = new SVC();
        while(sel != 0){
            Menu();
            sel = scanner.nextInt();
            switch (sel){
                case 1:
                    service.addBank();
                    break;
                case 2:{
                    service.listBanks();
                    break;
                }

                case 3:{
                    service.addClient();
                    break;
                }

                case 4:{
                    service.listClients();
                    break;
                }

                case 5:{
                    service.addPocket();
                    break;
                }

                case 6:{
                    service.listPockets();
                    break;
                }

                case 7:{
                    service.addAccount();
                    break;
                }

                case 8:{
                    service.listAccounts();
                    break;
                }

                case 9:{
                    service.addCard();
                    break;
                }

                case 10:{
                    service.listCards();
                    break;
                }

                case 11:{
                    service.addVisa();
                    break;
                }

                case 12:{
                    service.listVisas();
                    break;
                }

                case 13:{
                    service.addMasterCard();
                    break;
                }

                case 14:{
                    service.listMasterCards();
                    break;
                }

                case 15:{
                    service.addMajor();
                    break;
                }

                case 16:{
                    service.listMajors();
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
