package com.company.services;


import com.company.products.*;
import com.company.helper.AuditHelper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UserOptions {

    public void searchCPU(Product[] prod){
        ArrayList<Product> cpus = new ArrayList<Product>();

        for (int i=0; i < prod.length; i++){
            if (prod[i].getCat().contains("CPU"))
                cpus.add(prod[i]);
        }

        LocalDate callTime = LocalDate.now();
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        AuditHelper.printCall(functionName, callTime);

        System.out.println("Give a search term: ");
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int nr = 0;
        String term = scanner.nextLine().toLowerCase();

        for(int i=0; i<cpus.size(); i++){
            if (cpus.get(i).getName().toLowerCase().contains(term)){
                nr++;
                stack.push(i);
            }
        }
        if (nr != 0) {
            System.out.println("Produsele gasite sunt: ");
            for (int i = 0; i < nr; i++) {
                System.out.println(cpus.get(stack.peek()).getName() + " cu stocul: " + cpus.get(stack.peek()).getStock());
                stack.pop();
            }
        }
        else System.out.println("Nu a fost gasit nici un produs");
    }

    public void searchGPU(Product[] prod) {
        ArrayList<Product> gpus = new ArrayList<Product>();

        for (int i=0; i < prod.length; i++){
            if (prod[i].getCat().contains("GPU"))
                gpus.add(prod[i]);
        }
        LocalDate callTime = LocalDate.now();
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        AuditHelper.printCall(functionName, callTime);

        System.out.println("Give a search term: ");
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int nr = 0;
        String term = scanner.nextLine().toLowerCase();

        for(int i=0; i<gpus.size(); i++){
            if (gpus.get(i).getModel().toLowerCase().contains(term)){
                nr++;
                stack.push(i);
            }
        }
        if (nr != 0) {
            System.out.println("Produsele gasite sunt: ");
            for (int i = 0; i < nr; i++) {
                System.out.println(gpus.get(stack.peek()).getModel() + " cu stocul: " + gpus.get(stack.peek()).getStock());
                stack.pop();
            }
        }
        else System.out.println("Nu a fost gasit nici un produs");
    }

    public void searchRAM(Product[] prod){
        ArrayList<Product> rams = new ArrayList<Product>();

        for (int i=0; i < prod.length; i++){
            if (prod[i].getCat().contains("RAM"))
                rams.add(prod[i]);
        }
        LocalDate callTime = LocalDate.now();
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        AuditHelper.printCall(functionName, callTime);

        System.out.println("Give a search term: ");
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int nr = 0;
        String term = scanner.nextLine().toLowerCase();

        for(int i=0; i<rams.size(); i++){
            if (rams.get(i).getManufacturer().toLowerCase().contains(term) || rams.get(i).getType().toLowerCase().contains(term)){
                nr++;
                stack.push(i);
            }
        }
        if (nr != 0) {
            System.out.println("Produsele gasite sunt: ");
            for (int i = 0; i < nr; i++) {
                System.out.println(rams.get(stack.peek()).getManufacturer() + " " +rams.get(stack.peek()).getType() + " cu stocul: " + rams.get(stack.peek()).getStock());
                stack.pop();
            }
        }
        else System.out.println("Nu a fost gasit nici un produs");
    }

    public void searchHDD(Product[] prod){
        ArrayList<Product> hdds = new ArrayList<Product>();

        for (int i=0; i < prod.length; i++){
            if (prod[i].getCat().contains("HDD"))
                hdds.add(prod[i]);
        }
        LocalDate callTime = LocalDate.now();
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        AuditHelper.printCall(functionName, callTime);

        System.out.println("Give a search term: ");
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int nr = 0;
        String term = scanner.nextLine().toLowerCase();

        for(int i=0; i<hdds.size(); i++){
            if (hdds.get(i).getManufacturer().toLowerCase().contains(term)){
                nr++;
                stack.push(i);
            }
        }
        if (nr != 0) {
            System.out.println("Produsele gasite sunt: ");
            for (int i = 0; i < nr; i++) {
                System.out.println(hdds.get(stack.peek()).getManufacturer() + " cu stocul: " + hdds.get(stack.peek()).getStock());
                stack.pop();
            }
        }
        else System.out.println("Nu a fost gasit nici un produs");
    }

    public void searchSSD(Product[] prod) {
        ArrayList<Product> ssds = new ArrayList<Product>();

        for (int i=0; i < prod.length; i++){
            if (prod[i].getCat().contains("SSD"))
                ssds.add(prod[i]);
        }
        LocalDate callTime = LocalDate.now();
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        AuditHelper.printCall(functionName, callTime);

        System.out.println("Give a search term: ");
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int nr = 0;
        String term = scanner.nextLine().toLowerCase();

        for(int i=0; i<ssds.size(); i++){
            if (ssds.get(i).getManufacturer().toLowerCase().contains(term)){
                nr++;
                stack.push(i);
            }
        }
        if (nr != 0) {
            System.out.println("Produsele gasite sunt: ");
            for (int i = 0; i < nr; i++) {
                System.out.println(ssds.get(stack.peek()).getManufacturer() + " cu stocul: " + ssds.get(stack.peek()).getStock());
                stack.pop();
            }
        }
        else System.out.println("Nu a fost gasit nici un produs");
    }






    public void stocProdus(Product[] products){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Termenul de cautare: ");
        String term = scanner.next();
        int index = -1;
        int st = 0;
        for(int i=0; i < products.length; i++)
            if (products[i].getManufacturer().toLowerCase().contains(term.toLowerCase())){
                index = i;
                st += products[i].getStock();
            }

        if (index > -1) {
            System.out.println("Produsul este: " + products[index].getManufacturer());
            System.out.println("Stocul tuturor produselor de la acest producator este: " + st);
        }
        else System.out.println("Produs inexistent");
    }
}
