package com.company.services;


import com.company.products.*;
import com.company.helper.AuditHelper;

import java.sql.*;
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

    public void createCPUS() throws SQLException {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://ANDREI-LAPTOP-O\\SQLEXPRESS;databaseName=pao";
            String user = "sa";
            String pass = "1234";
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println(conn);
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//            System.out.println("am trecut prin conexiune");

        } catch (SQLException ex) {
//            ex.printStackTrace();
        }

        Statement stmt = conn.createStatement();
        ResultSet rst;

        rst=stmt.executeQuery("CREATE TABLE cpus (" +
                "nume VARCHAR(10) primary key," +
                "price INT," +
                "stock INT," +
                "purchase_date DATE, " +
                "socket VARCHAR(10)," +
                "frequency INT," +
                "turboFrequency INT," +
                "cores INT," +
                "threads INT," +
                "lithography INT," +
                "maximum_memory INT);");
        System.out.println("AICI" + rst);
        stmt.close();
        conn.close();


    }

    public void updateCPUS() throws SQLException {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://ANDREI-LAPTOP-O\\SQLEXPRESS;databaseName=pao";
            String user = "sa";
            String pass = "1234";
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println(conn);
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//            System.out.println("am trecut prin conexiune");

        } catch (SQLException ex) {
//            ex.printStackTrace();
        }

        Statement stmt = conn.createStatement();
        ResultSet rst;

        rst=stmt.executeQuery("UPDATE cpus " +
                "SET price = 100");
//        System.out.println("AICI" + rst);
        stmt.close();
        conn.close();


    }
    public void readCPUS() throws SQLException {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://ANDREI-LAPTOP-O\\SQLEXPRESS;databaseName=pao";
            String user = "sa";
            String pass = "1234";
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println(conn);
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//            System.out.println("am trecut prin conexiune");

        } catch (SQLException ex) {
//            ex.printStackTrace();
        }

        Statement stmt = conn.createStatement();
        ResultSet rst;

        rst=stmt.executeQuery("SELECT * " +
                "FROM cpus");

        while(rst.next()){
            //Retrieve by column name
            int socket  = rst.getInt("socket");
            int pret = rst.getInt("price");
            int stock = rst.getInt("stock");
            String nume = rst.getString("nume");


            //Display values
            System.out.print("Nume: " + nume);
            System.out.print(", Pret: " + pret);
            System.out.print(", Stock: " + stock);
            System.out.println(", Socket: " + socket);
        }
        rst.close();

        stmt.close();
        conn.close();


    }

    public void deleteCPUS() throws SQLException {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://ANDREI-LAPTOP-O\\SQLEXPRESS;databaseName=pao";
            String user = "sa";
            String pass = "1234";
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println(conn);
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//            System.out.println("am trecut prin conexiune");

        } catch (SQLException ex) {
//            ex.printStackTrace();
        }

        Statement stmt = conn.createStatement();
        ResultSet rst;

        rst=stmt.executeQuery("DELETE TOP (1) "+"FROM cpus");


        rst.close();

        stmt.close();
        conn.close();


    }
}
