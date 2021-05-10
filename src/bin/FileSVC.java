package bin;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class FileSVC {
    private static FileSVC ins;

    public static FileSVC getInstance(){
        if(ins == null)
            ins = new FileSVC();

        return ins;
    }

    public String isNull(String s){
        return s.equals("null") ? null : s;
    }

    public void fileadd(Client c, BufferedWriter bfrdr) throws IOException{
        bfrdr.write(c.convert2CSV());
    }

    public void fileadd(Client c, String file) throws  IOException{
        try (BufferedWriter bfrdr = new BufferedWriter(new FileWriter(file))){
            fileadd(c, bfrdr);
        }
    }

    public void fileaddClients(Iterable<Client> clients, String file){
        try (BufferedWriter bfrdr = new BufferedWriter(new FileWriter(file))){
            for(Client c: clients){
                fileadd(c, bfrdr);
                bfrdr.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> readfileClient(String file) throws IOException, ParseException {
        try (BufferedReader bfrdr = new BufferedReader(new FileReader(file))){
            return readfileClient(bfrdr);
        }
    }

    public ArrayList<Client> readfileClient(BufferedReader bfrdr) throws IOException, ParseException {
        ArrayList<Client> rez = new ArrayList<>();
        String s = bfrdr.readLine();

        while (!s.equals("null")){
            String[] inf = s.split(";");
            String age, name, gender, nra, nrc, firstname, lastname;
            int nracc, nrcards;
            ArrayList<Account> accList = new ArrayList<>();
            ArrayList<Card> cardList = new ArrayList<>();

            if(!(inf[0].length() > 8) || !inf[0].startsWith("Client: "))
                throw new InvalidPropertiesFormatException("format err");
            else {
                age = isNull(inf[0].substring(8));
                name = isNull(inf[1]);
                firstname = name.split(" ")[0];
                lastname = name.split(" ")[1];
                gender = isNull(inf[2]);
                nra = isNull(inf[3]);
                nracc = nra.charAt(0) - '0';
                //conturi
                for(int i = 0; i < nracc * 4; i=i + 4){
                    String iban, curr, bal, cd;
                    iban = isNull(inf[4+i]);
                    curr = isNull(inf[4+i+1]);
                    bal = isNull(inf[4+i+2]);
                    cd = isNull(inf[4+i+3]);
                    int balance = Integer.parseInt(bal);
                    Account acc = new Account(iban,curr);
                    acc.setBalance(balance);
                    Date d = (new SimpleDateFormat().parse(cd));
                    acc.editDate(d);
                    accList.add(acc);
                }
                //carduri
                int start = 4+nracc*4;
                nrc=isNull(inf[start]);
                nrcards = Integer.parseInt(nrc);
                for(int i = 0; i < nrcards*4; i=i+4){
                    String cn, ed, cvv;
                    cn = isNull(inf[start + i]);
                    ed = isNull(inf[start+i+1]);
                    cvv = isNull(inf[start+i+2]);

                    nra = isNull(inf[start+i+3]);
                    nracc = nra.charAt(0) - '0';
                    //conturi
                    for(int j = start+i+4; j < nracc * 4; j=j + 4){
                        String iban, curr, bal, cd;
                        iban = isNull(inf[4+j]);
                        curr = isNull(inf[4+j+1]);
                        bal = isNull(inf[4+j+2]);
                        cd = isNull(inf[4+j+3]);
                        int balance = Integer.parseInt(bal);
                        Account acc = new Account(iban,curr);
                        acc.setBalance(balance);
                        Date d = (new SimpleDateFormat().parse(cd));
                        acc.editDate(d);
                        accList.add(acc);
                    }
                }
            }
            Client c = new Client();
            c.setAge(Integer.parseInt(age));
            c.setFirstName(firstname);
            c.setLastName(lastname);
            c.setGender(gender.charAt(0));
            c.setaccList(accList);
            c.setcardList(cardList);
            rez.add(c);
        }
        return rez;
    }

    
}
