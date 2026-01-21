package org.example;

import org.example.Bank;

import java.util.Scanner;
public class Main {

    // BANK PRINCIPALE
    static Bank b = new Bank(2,"CIH Bank","Mohammed 5 avenue",0533212121);

    // MAIN MENU
    public static void e_Bank(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("##################### E-BANK #####################");
            System.out.println("1. Admin Mode");
            System.out.println("2. Client Mode");
            System.out.println("3. Close");
            System.out.println("###################################################");
            System.out.println("Make ur choise : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 :
                    adminMenu();
                    break;
                case 2 :
                    clientMenu();
                    break;
                case 3 :
                    break;
                default:
                    System.out.println("invalid Input !!");
                    break;

            }
        }while(choice != 0);


    }

    // ADMIN MENU
    public static void adminMenu() {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("################### Admin Mode ##################");
            System.out.println("1. Display Accounts");
            System.out.println("2. Add New Client");
            System.out.println("3. Add New Account");
            System.out.println("4. Delete an Account");
            System.out.println("5. Saving Accounts Management");
            System.out.println("6. Export Accounts File");
            System.out.println("7. Go Back to Main Menu");
            System.out.println("#################################################");
            System.out.println("Make ur choise : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    b.afficher_comptes();
                    break;
                case 2:
                    b.add_client();
                    break;
                case 3:
                    b.add_compte();
                    break;
                case 4:
                    b.delete_compte();

                    break;
                case 5:
                    saving_Acounts();
                    break;
                case 6:
                  ExcelGenerator.execute();
                    break;
                case 7:
                    e_Bank();
                    break;
                default:
                    System.out.println("invalid Input !!");
                    break;

            }

        } while (choice != 0);
    }

    // SAVING ACCOUNT MANAGEMENT
    public static void  saving_Acounts(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("################ Saving Accounts ###############");
            System.out.println("1. add a New Saving account");
            System.out.println("2. display saving accounts");
            System.out.println("3. delete saving account");
            System.out.println("4. Go Back to Main Menu");
            System.out.println("#################################################");
            System.out.println("Make ur choise : ");
            choice = sc.nextInt();

            switch (choice){
                case 1 :
                    b.add_Saving_acompte();
                    break;
                case 2 :
                    b.display_saving_accounts();
                    break;
                case 3 :
                    b.delete_Saving_account();
                    break;
                case 4:
                    adminMenu();
                    break;
                default:
                    System.out.println("invalid Input !!");
                    break;
            }
        }while(choice != 0);
    }

    //  CLIENT MENU
    public static void clientMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("##################### Client Mode #####################");
            System.out.println("1. Display Sold");
            System.out.println("2. Depot Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display saving account Sold");
            System.out.println("5. Depot Money in Saving account");
            System.out.println("6. Go Back to Main Menu");
            System.out.println("###################################################");
            System.out.println("Make ur choise : ");
            choice = sc.nextInt();

            switch (choice){
                case 1 :
                    b.display_sold();
                    break;
                case 2 :
                    b.deposit();
                    break;
                case 3 :
                    b.withraw();
                    break;
                case 4:
                    b.display_Sold_Saving_Account();
                    break;
                case 5:
                    b.deposit_Saving_Account();
                    break;
                case 6:
                    e_Bank();
                    break;
                default:
                    System.out.println("invalid Input !!");
                    break;
            }
        }while(choice != 0);
    }




    public static void main(String[] args) {

        //*********************//*****************************
        e_Bank();           // Main Function Run the Program
        //*****************//*********************************


    }
}
