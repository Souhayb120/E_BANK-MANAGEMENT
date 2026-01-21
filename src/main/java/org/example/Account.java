package org.example;

import java.util.Scanner;

public class Account {
    private int n_compte;
    private double sold_initial;
    private Client client;
    private static int n_counter = 1;



    public Account(double sold_initial , Client client) {
        this.n_compte = n_counter++;
        this.sold_initial = sold_initial;
        this.client = client;
    }



    Scanner sc = new Scanner(System.in);
    public int getN_compte() {
        return n_compte;
    }

    public void setN_compte(int n_compte) {
        this.n_compte = n_compte;
    }

    public double getSold_initial() {
        return sold_initial;
    }

    public void setSold_initial(double sold_initial) {
        this.sold_initial = sold_initial;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    @Override
    public String toString() {
        return "Account{" +
                "n_compte=" + n_compte +
                ", sold_initial=" + sold_initial +
                ", client=" + client +
                '}';
    }
}
