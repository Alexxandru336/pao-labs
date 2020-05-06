package com.company.human;

import java.util.Scanner;

public class Customer implements Clients{
    String name;
    static int total = 0;
    String paymentMet;

    Customer(String name, String pay){
        total ++;
        this.name = name;
        this.paymentMet = pay;
    }

    public Customer(){ total ++; }

    public String getName() {return this.name;}

    public String setName(String name) { return this.name = name;}

    public int getTotal() { return total;}

    @Override
    public void read(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello MR/MRS Cashier! Please enter your client's name:");
        this.name = scanner.nextLine();

        System.out.println("Say hello to you client " + name + ". What method of payment do they choose?(cash,card):");
        this.paymentMet = scanner.nextLine();
    }
}
