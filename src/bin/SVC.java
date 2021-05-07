package bin;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SVC {
    static List<Bank> bankList = new ArrayList<>();
    static List<Client> clientList = new ArrayList<>();
    static List<Card> cardList = new ArrayList<>();
    static List<Account> accountList = new ArrayList<>();
    static List<Pocket> pocketList = new ArrayList<>();
    static List<MasterCard> masterCardList = new ArrayList<>();
    static List<Visa> visaList = new ArrayList<>();
    static List<Major> majorList = new ArrayList<>();

    public void listBanks(){
        int i = 0;
        if(bankList.isEmpty())
            System.out.println("No banks");
        else
            for(Bank b : bankList) {
                System.out.println("--- " + i + " ---");
                b.BankInfo();
                i++;
                System.out.println();
            }
    }

    public void listClients(){
        if(clientList.isEmpty())
            System.out.println("No clients");
        else
            for(Client c : clientList) {
                c.ClientInfo();
                System.out.println();
            }
    }

    public void listPockets(){
        if(pocketList.isEmpty())
            System.out.println("No pockets");
        else
            for(Pocket p : pocketList) {
                System.out.println(p);
                System.out.println();
            }
    }

    public void listAccounts(){
        if(accountList.isEmpty())
            System.out.println("No accounts");
        else
            for(Account a : accountList) {
                a.AccountInfo();
                System.out.println();
            }
    }

    public void listCards(){
        if(cardList.isEmpty())
            System.out.println("No cards");
        else
            for(Card c: cardList) {
                c.CardInfo();
                System.out.println();
            }
    }

    public void listMasterCards(){
        if(masterCardList.isEmpty())
            System.out.println("No MasterCards");
        else
            for(MasterCard m : masterCardList) {

                m.CardInfo();
                System.out.println();
            }
    }

    public void listVisas(){
        if(visaList.isEmpty())
            System.out.println("No Visa cards");
        else
            for (Visa v: visaList) {
                v.CardInfo();
                System.out.println();
            }
    }

    public void listMajors(){
        if(majorList.isEmpty())
            System.out.println("No majors");
        else
            for(Major m: majorList) {
                System.out.println(m);
                System.out.println();
            }
    }

    public void addBank(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Bank b = new Bank();
        System.out.println("Enter bank name: ");
        String name = scanner.next();
        b.setName(name);
        System.out.println("Enter bank adress: ");
        String adress = scanner.next();
        b.setAdress(adress);
        bankList.add(b);
        System.out.println("Bank sucessfully added");
        bankList.sort(Comparator.comparing(Bank::getName));
    }

    public void addMajor(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        Major m = new Major();
        System.out.println("Enter major age: ");
        int age = scanner.nextInt();
        m.setAge(age);

        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        m.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        m.setLastName(lastName);

        System.out.println("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);
        m.setGender(gender);
        majorList.add(m);
    }

    public void addCard(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        Card c = new Card();
        System.out.println("Card number: ");
        String cardnumber = scanner.next();
        System.out.println("nr card setat: " + cardnumber);
        System.out.println("e valid? "+ c.cardnumberisValid(cardnumber));
        c.setCardNumber(cardnumber);

        System.out.println("CVV: ");
        int cvv = scanner.nextInt();
        System.out.print("cvv setat: " + cvv);
        System.out.println("e valid? "+ c.cvvisValid(cvv));

        c.setCVV(cvv);
        System.out.print("cardul setat e valid? " + c.isValid());
       if(c.isValid())
            cardList.add(c);
       else {
           System.out.println("Sorry, something went wrong. Try again.");
           addCard();
       }
    }

    public void addVisa(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        Visa c = new Visa();
        System.out.println("Card number: ");
        String cardnumber = scanner.next();
        c.setCardNumber(cardnumber);

        System.out.println("CVV: ");
        int cvv = scanner.nextInt();
        c.setCVV(cvv);

        if(c.isValid())
            visaList.add( c);
        else {
            System.out.println("Sorry, something went wrong. Try again.");
            addVisa();
        }
    }

    public void addMasterCard(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        MasterCard c = new MasterCard();
        System.out.println("Card number: ");
        String cardnumber = scanner.next();
        c.setCardNumber(cardnumber);

        System.out.println("CVV: ");
        int cvv = scanner.nextInt();
        c.setCVV(cvv);

        if(c.isValid())
            masterCardList.add(c);
        else {
            System.out.println("Sorry, something went wrong. Try again.");
            addMasterCard();
        }
    }

    public void addAccount(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Account a = new Account();

        System.out.println("Enter IBAN number: ");
        String i = scanner.next();
        a.setIBAN(i);

        System.out.println("Enter currency: ");
        String curr = scanner.next();
        a.setCurrency(curr);

        System.out.println(i);
        System.out.println(curr);

        if(a.isValid()){
            System.out.println("Account succesfully created!");
            accountList.add(a);
        }
        else{
            System.out.println("Sorry, something went wrong. Try again.");
            addAccount();
        }


    }

    public void addClient(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Enter client age: ");
        Client c = new Client();
        int age = scanner.nextInt();
        c.setAge(age);

        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        c.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        c.setLastName(lastName);

        System.out.println("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);
        c.setGender(gender);

        System.out.println("Please select a bank ");
        listBanks();
        int banknr = scanner.nextInt();
        if(banknr < bankList.size()) {
            bankList.get(banknr).addClient(c);
            System.out.println("This client has succesfully been added to " + bankList.get(banknr).getName());
        }
        else {
            System.out.println("One more try, enter a correct value");
            if(banknr < bankList.size()) {
                bankList.get(banknr).getClientList().add(c);
                System.out.println("This client has succesfully been added to " + bankList.get(banknr).getName());
            }

        }

        System.out.println("Select a type of Card for this client: ");
        System.out.println("1) Normal card");
        System.out.println("2) Visa Card");
        System.out.println("3) MasterCard");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                //apelam addCard
                addCard();
                Card card = cardList.get(cardList.size()-1);
                c.addCard(card);
                break;
            case 2:
                //apelam addVisa
                addVisa();
                Visa visa = visaList.get(visaList.size()-1);
                c.addCard(visa);
                break;
            case 3:
                //apelam addMasterCard
                addMasterCard();
                MasterCard mas = masterCardList.get(masterCardList.size()-1);
                c.addCard(mas);
                break;
        }

        System.out.println("Now, we need to create an account...");
        //apelam addAccount
        addAccount();
        Account acc = accountList.get(accountList.size()-1);
        c.addAccount(acc);

    }

    public void addPocket(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("To add a pocket, you must first add an account.");
        addAccount();
        Pocket p = new Pocket();
        Account acc = accountList.get(accountList.size()-1);

        System.out.println("Now select a maximum deposit amount");
        int x = scanner.nextInt();
        p.setMaxAmount(x);
        p.setLinkedAccount(acc);

        pocketList.add(p);
    }

}
