package org.example;

import  java.util.List;
import java.util.ArrayList;

public class Client extends Persone {
    private double n_client ;
    private List<Account> accountList;

    public Client(String name ,int age , int n_client) {
        super(name, age);
        this.n_client = n_client;
        this.accountList = new ArrayList<>();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public double getN_client() {
        return n_client;
    }

    public void setN_client(double n_client) {
        this.n_client = n_client;
    }
}
