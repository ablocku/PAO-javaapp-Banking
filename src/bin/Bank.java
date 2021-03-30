package bin;

import java.util.ArrayList;
import java.util.List;

public class Bank extends CIFGEN{
    private String name, adress;
    private List<Client> clientList = new ArrayList<>();
    private final int CIF = getRandCIF();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(nameisValid(name))
            this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        if(adressisValid(adress))
            this.adress = adress;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        if(clientListisValid(clientList))
            this.clientList = clientList;
    }

    public int getCIF() {
        return CIF;
    }

    public Bank(){
        this.name = "";
        this.adress = "";
        this.clientList = new ArrayList<>();
    }

    public Bank(String _name, String _adress){
        setName(_name);
        setAdress(_adress);
    }

    public Bank(String _name, String _adress, List<Client> _clientList){
        setName(_name);
        setAdress(_adress);
        setClientList(_clientList);
    }

    public boolean nameisValid(String name){
        if(!name.equals(""))
            return true;
        else {
            System.out.println("Name is not valid!");
            return false;
        }
    }

    public boolean adressisValid(String adress){
        if(!adress.equals(""))
            return true;
        else {
            System.out.println("Name is not valid!");
            return false;
        }
    }

    public boolean clientListisValid(List<Client> clientList){
        return clientList.isEmpty();
    }



    public void addClient(Client client){

        clientList.add(client);
        clientList.stream().sorted();
    }

    public void removeClient(Client client){
        clientList.remove(client);
    }

    public void BankInfo(){
        System.out.println("Bank name: " + getName());
        System.out.println("Bank adress: " + getAdress());
        System.out.println("Bank CIF: " + getCIF());
        System.out.println("--- Bank Clients ---");
        System.out.println();
        for(Client c: clientList){
            c.ClientInfo();
            System.out.println();
        }

        System.out.println();
    }

}
