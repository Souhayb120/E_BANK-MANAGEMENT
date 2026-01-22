package org.example;
import  java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
public class Bank {
    private int bank_id;
    private String bank_name;
    private String adress;
    private int phone;
    static List<Account> accountlist;
    private List<SavingAccount> savingAccountList;
    private List<Client> clientList;

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

    public List<SavingAccount> getSavingAccountList() {
        return savingAccountList;
    }

    public void setSavingAccountList(List<SavingAccount> savingAccountList) {
        this.savingAccountList = savingAccountList;
    }

    public static List<Account> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(List<Account> accountlist) {
        this.accountlist = accountlist;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    //***************************
    // Admin Methods
    //***************************


    // DISPLAY ACCOUNTS
    public void afficher_comptes() {
        try {
            if (!accountlist.isEmpty()) {
                for (Account act : accountlist) {
                    System.out.println(act.getClient().getName() + " Account N° " + act.getN_compte() + " Sold " + act.getSold_initial());
                }
            } else {
                System.out.println("no accounts currently !!");
            }
        } catch (Exception e) {
            System.out.println("somthing wrong Displaying Accounts !!!");
            ;
        }

    }


    // ADD CLIENT
    public void add_client() {
        try {
            System.out.println(" Enter your name :");
            String name = sc.nextLine();
            System.out.println(" Enter your age :");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println(" Enter your Client Number :");
            int ClientNumber = sc.nextInt();
            sc.nextLine();
            Client client = new Client(name, age, ClientNumber);
            clientList.add(client);
            System.out.println("client has added successfully");
        } catch (Exception e) {
            System.out.println("Errore : You have to enter a Number " + e);
            ;
        }

    }


    // add new account to an exested Client
    public void add_compte() {
        try {
            System.out.println(" Enter your Client_Number : ");
            int client_N = sc.nextInt();
            Client client = null;
            for (Client c : clientList) {
                if (c.getN_client() == client_N) {
                    client = c;
                    System.out.println("congrats you made it , counte created successfully");
                    System.out.println("current balace is 0.00$ , how much you wanna depost ");
                    double sold = sc.nextDouble();
                    Account account = new Account(sold, client);
                    accountlist.add(account);
                    System.out.println("operation done with success");
                    sc.nextLine();
                }
            }
            if (client == null) {
                System.out.println("sorry !! you are not a client of us yet, you have to register first !!");
            }
        } catch (Exception e) {
            System.out.println("Errore Adding new Account !!! , make sure u enter Numbers !!! " + e);
        }
    }


    // delete exicted compte
    public void delete_compte() {

        try {
            System.out.println("Enter Account Number to Delete it : ");
            int number = sc.nextInt();
            Account account = null;
            for (Account act : accountlist) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null ) {
                if( account.getSold_initial() > 0){
                    System.out.println("you can't delete an Account that contains Money !!");
                }else{

                    accountlist.remove(account);
                    System.out.println("account delete successfully !!");
                }
            } else {
                System.out.println("account not found !!");
            }

        } catch (Exception e) {
            System.out.println("Errore Deleting the Account !!, make sure u enter a Number not a string !! " + e);
        }

    }


    //***************************
    // Client Methods
    //***************************


    //DEPOT MONEY
    public void deposit() {
        try {
            System.out.println("Enter Account Number : ");
            int number = sc.nextInt();
            Account account = null;
            for (Account act : accountlist) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("how much u wanna depot ");
                double money = sc.nextDouble();
                account.setSold_initial(account.getSold_initial() + money);
                System.out.println("current sold now : " + account.getSold_initial());

            } else {
                System.out.println("account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore depositing Money : make sure u enter a number!! " + e);
        }
    }


    // WITHDRAW MONEY
    public void withraw() {
        try {
            System.out.println("Enter Account Number : ");
            int number = sc.nextInt();
            Account account = null;
            for (Account act : accountlist) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("how much u wanna withdraw ");
                double money = sc.nextDouble();
                account.setSold_initial(account.getSold_initial() - money);
                System.out.println("current sold now : " + account.getSold_initial());

            } else {
                System.out.println("account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore withdraw Money : make sure u enter a Number !!!  " + e);
        }

    }


    //DISPLAY SOLD
    public void display_sold() {

        try {
            System.out.println("Enter Account Number : ");
            int number = sc.nextInt();
            Account account = null;
            for (Account act : accountlist) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("current sold now : " + account.getSold_initial());
            } else {
                System.out.println("account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore displaying balance of ur account : make sure u enter a number !! " + e);
        }

    }


    //***************************
    // GESTION OF SAVING ACCOUNTS
    //***************************


    // ADD A NEW SAVING ACCOUNT
    public void add_Saving_acompte() {
        try {
            System.out.println(" Enter your Client_Number : ");
            int client_N = sc.nextInt();
            Client client = null;
            for (Client c : clientList) {
                if (c.getN_client() == client_N) {
                    client = c;
                    System.out.println("congrats you made it , ur Saving Account created successfully");
                    System.out.println("current balance is 0.00$ , how much you wanna depost ");
                    double sold = sc.nextDouble();

                    SavingAccount account = new SavingAccount(sold, client);
                    account.setSold_initial(account.calculerIntrest());
                    savingAccountList.add(account);
                    System.out.println("operation done with success");
                    sc.nextLine();
                }
            }
            if (client == null) {
                System.out.println("sorry !! you are not a client of us yet, you have to register first !!");
            }
        } catch (Exception e) {
            System.out.println("Errore Adding new Saving Account , make sure u enter a number !! " + e);
        }

    }


    // DISPLAY SOLD OF THE SAVING ACCOUNT
    public void display_Sold_Saving_Account() {
        try {
            System.out.println("Enter Saving Account Number : ");
            int number = sc.nextInt();
            SavingAccount account = null;
            for (SavingAccount act : savingAccountList) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("current sold now : " + account.getSold_initial());
            } else {
                System.out.println("saving account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore Displaying Balance of ur Saving account !! make sure u enter a number !! " + e);
        }
    }


    // DEPOT MONEY TO THE SAVING ACCOUNT
    public void deposit_Saving_Account() {
        try {
            System.out.println("Enter Account Number : ");
            int number = sc.nextInt();
            SavingAccount account = null;
            for (SavingAccount act : savingAccountList) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("how much u wanna depot in ur Saving Account ");
                double money = sc.nextDouble();
                account.setSold_initial(account.getSold_initial() + money);
                System.out.println("Saving Account Balance is : " + account.getSold_initial());

            } else {
                System.out.println("account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore depositing Money into ur Saving account , make sure u enter a number !! " + e);
        }

    }


    // WITHDRAW MONEY From Saving Account
    public void withraw_Saving_account(){
      try{
          System.out.println("Enter Account Number : ");
          int number = sc.nextInt();
          SavingAccount account = null;
          for(SavingAccount act : savingAccountList){
              if(number == act.getN_compte()){
                  account = act;
              }
          }
          if(account != null){
              double money;
              do{
                  System.out.println("how much u wanna withdraw ");
                  money = sc.nextDouble();
                  if(money > 100){
                      System.out.println("u can't withdraw this amount of money from ur saving account !!!");
                      System.out.println("try less than 100$");
                  }
              }while(money > 100);
              account.setSold_initial(account.getSold_initial() - money);
              System.out.println("current sold now : " + account.getSold_initial());
          }else {
              System.out.println("account not found");
          }

      } catch (Exception e) {
          System.out.println("errore Withdraw Money!!");
      }


    }

    // DISPLAY Saving ACCOUNTS
    public void display_saving_accounts(){
        try{
            if(!savingAccountList.isEmpty()){
                for(SavingAccount act :  savingAccountList){
                    System.out.println(act.getClient().getName() + " Saving Account N° " + act.getId() + " Sold " + act.getSold_initial());
                }
            }else{
                System.out.println("no Saving accounts currently !!");
            }
        } catch (Exception e) {
            System.out.println("Errore Diplaying Saving Accounts, make sure u enter a number !! " + e);
        }

    }


    // DELETE SAVING ACCOUNT
    public void delete_Saving_account(){
        try{
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
        } catch (Exception e) {
            System.out.println("Errore Deleting Saving account , make sure u enter a number !! " + e);
        }

    }

    //********************************
    // TRENSFER MONEY TO OTHER ACCOUNT
    //********************************


    public void make_vairment(){
        try {
            System.out.println("Enter Account Number : ");
            int number = sc.nextInt();
            Account account = null;
            for (Account act : accountlist) {
                if (number == act.getN_compte()) {
                    account = act;
                }
            }
            if (account != null) {
                System.out.println("Entrer Number accounte de  benificial ");
                int account_benificial = sc.nextInt();
                Account account_b = null;
                for (Account act : accountlist) {
                    if (account_benificial == act.getN_compte()) {
                        account_b = act;
                    }
                }
                if (account_b != null){
                    System.out.println("how much money u wanna trensfer  to " + account_b.getClient().getName());
                    double money = sc.nextDouble();
                    if(money > account.getSold_initial() || money < 1){
                        System.out.println("Current Balance is not enough to make this operation !!");
                    }else{
                        account.setSold_initial(account.getSold_initial() - money);
                        System.out.println(" -" + money);
                        System.out.println("Sender Current Balance " + account.getSold_initial());
                        account_b.setSold_initial(account_b.getSold_initial() + money);
                        System.out.println(" +" + money);
                        System.out.println("Beneficiary Current Balance " + account_b.getSold_initial());
                        System.out.println("*****************************************");
                        System.out.println("Operation Made Successfully !!");
                    }

                }else{
                    System.out.println("account benificial not found");
                }
            } else {
                System.out.println("account not found !!");
            }
        } catch (Exception e) {
            System.out.println("Errore Trenfer Money " + e);
        }
    }

}

