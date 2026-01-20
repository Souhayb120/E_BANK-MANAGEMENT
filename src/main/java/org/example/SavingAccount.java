package org.example;

public class SavingAccount extends Account{
    private double intrest;
    private int id ;
    private double taux = 0.10;
    private static  int counteur = 1;
    public SavingAccount(double sold_initial, Client client) {
        super(sold_initial, client);
        id = counteur++;
        intrest = (getSold_initial() * taux / 100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIntrest() {
        return intrest;
    }

    public void setIntrest(double intrest) {
        this.intrest = intrest;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


    public double calculerIntrest(){
        double result =  getSold_initial() + getIntrest();
        return result;
    }
}