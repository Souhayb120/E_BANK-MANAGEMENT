package org.example;

import  java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private int bank_id;
    private String bank_name;
    private String adress;
    private int phone;
    List<Account> accountlist;
    List<SavingAccount> savingAccountList;
    List<Client> clientList;

    public Bank(int bank_id, String bank_name, String adress, int phone) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.adress = adress;
        this.phone = phone;
        this.accountlist = new ArrayList<>();
        this.clientList = new ArrayList<>();
        this.savingAccountList = new ArrayList<>();

    }
    // Declare Scanner Variable to Get User Input
    Scanner sc = new Scanner(System.in);

    // GETTER AND SETTERS
    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    //***************************
    // Admin Methods
    //***************************


    // DISPLAY ACCOUNTS
    public void afficher_comptes(){
        if(!accountlist.isEmpty()){
            for(Account act :  accountlist){
                System.out.println(act.getClient().getName() + " Account N° " + act.getN_compte() + " Sold " + act.getSold_initial());
            }
        }else{
            System.out.println("no accounts currently !!");
        }
    }


    // ADD CLIENT
    public void add_client(){
        System.out.println(" Enter your name :");
        String name = sc.nextLine();
        System.out.println(" Enter your age :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println(" Enter your Client Number :");
        int ClientNumber = sc.nextInt();
        sc.nextLine();
        Client client = new Client(name,age,ClientNumber);
        clientList.add(client);
        System.out.println("client has added successfully");
    }


    // add new account to an exested Client
    public void add_compte(){
        System.out.println(" Enter your Client_Number : ");
        int client_N = sc.nextInt();
        Client client = null;
        for (Client  c : clientList){
            if(c.getN_client() == client_N){
                client = c;
                System.out.println("congrats you made it , counte created successfully");
                System.out.println("current balace is 0.00$ , how much you wanna depost ");
                double sold = sc.nextDouble();
                Account account = new Account(sold,client);
                accountlist.add(account);
                System.out.println("operation done with success");
                sc.nextLine();
            }
        }
        if(client == null){
            System.out.println("sorry !! you are not a client of us yet, you have to register first !!");
        }
    }


    // delete exicted compte
    public void delete_compte(){
        System.out.println("Enter Account Number to Delete it : ");
        int number = sc.nextInt();
        Account account = null;
        for(Account act : accountlist){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            accountlist.remove(account);
            System.out.println("account delete successfully !!");

        }else {
            System.out.println("account not found !!");
        }

    }


    //***************************
    // Client Methods
    //***************************


    //DEPOT MONEY
    public void depot(){
        System.out.println("Enter Account Number : ");
        int number = sc.nextInt();
        Account account = null;
        for(Account act : accountlist){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            System.out.println("how much u wanna depot ");
            double money = sc.nextDouble();
            account.setSold_initial(account.getSold_initial() + money);
            System.out.println("current sold now : " + account.getSold_initial());

        }else {
            System.out.println("account not found !!");
        }
    }


    // WITHDRAW MONEY
    public void withraw(){
        System.out.println("Enter Account Number : ");
        int number = sc.nextInt();
        Account account = null;
        for(Account act : accountlist){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            System.out.println("how much u wanna withdraw ");
            double money = sc.nextDouble();
            account.setSold_initial(account.getSold_initial() - money);
            System.out.println("current sold now : " + account.getSold_initial());

        }else {
            System.out.println("account not found !!");
        }
    }


    //DISPLAY SOLD
    public void display_sold(){
        System.out.println("Enter Account Number : ");
        int number = sc.nextInt();
        Account account = null;
        for(Account act : accountlist){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            System.out.println("current sold now : " + account.getSold_initial());
        }else {
            System.out.println("account not found !!");
        }
    }



    //***************************
    // GESTION OF SAVING ACCOUNTS
    //***************************



    // ADD A NEW SAVING ACCOUNT
    public void add_Saving_acompte(){

        System.out.println(" Enter your Client_Number : ");
        int client_N = sc.nextInt();
        Client client = null;
        for (Client  c : clientList){
            if(c.getN_client() == client_N){
                client = c;
                System.out.println("congrats you made it , ur Saving Account created successfully");
                System.out.println("current balance is 0.00$ , how much you wanna depost ");
                double sold = sc.nextDouble();

                SavingAccount account = new SavingAccount(sold,client);
                account.setSold_initial(account.calculerIntrest());
                savingAccountList.add(account);
                System.out.println("operation done with success");
                sc.nextLine();
            }
        }
        if(client == null){
            System.out.println("sorry !! you are not a client of us yet, you have to register first !!");
        }
    }


    // DISPLAY SOLD OF THE SAVING ACCOUNT
    public void display_Sold_Saving_Account(){
        System.out.println("Enter Saving Account Number : ");
        int number = sc.nextInt();
        SavingAccount account = null;
        for(SavingAccount act : savingAccountList){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            System.out.println("current sold now : " + account.getSold_initial());
        }else {
            System.out.println("saving account not found !!");
        }
    }


    // DEPOT MONEY TO THE SAVING ACCOUNT
    public void depot_Saving_Account(){
        System.out.println("Enter Account Number : ");
        int number = sc.nextInt();
        SavingAccount account = null;
        for(SavingAccount act : savingAccountList){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            System.out.println("how much u wanna depot in ur Saving Account ");
            double money = sc.nextDouble();
            account.setSold_initial(account.getSold_initial() + money);
            System.out.println("Saving Account Balance is : " + account.getSold_initial());

        }else {
            System.out.println("account not found !!");
        }
    }


    // DISPLAY Saving ACCOUNTS
    public void display_saving_accounts(){
        if(!savingAccountList.isEmpty()){
            for(SavingAccount act :  savingAccountList){
                System.out.println(act.getClient().getName() + " Saving Account N° " + act.getId() + " Sold " + act.getSold_initial());
            }
        }else{
            System.out.println("no Saving accounts currently !!");
        }
    }


    // DELETE SAVING ACCOUNT
    public void delete_Saving_account(){
        System.out.println("Enter ur Saving Account Number to Delete it : ");
        int number = sc.nextInt();
        SavingAccount account = null;
        for(SavingAccount act : savingAccountList){
            if(number == act.getN_compte()){
                account = act;
            }
        }
        if(account != null){
            savingAccountList.remove(account);
            System.out.println("Saving account deleted successfully !!");

        }else {
            System.out.println("Saving account not found !!");
        }
    }
}