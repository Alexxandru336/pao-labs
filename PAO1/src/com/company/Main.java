package com.company;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.company.helper.CSVHelper;
import com.company.products.*;
import com.company.services.JDBCConnection;
import com.company.services.UserOptions;
import com.company.human.Customer;

public class Main {

    public static void main(String[] args) throws Exception {
        File depozit = new File("CSV");
        ArrayList<List<String>> allList;
        ArrayList<CPU> cpus = new ArrayList<CPU>();
        ArrayList<HDD> hdds = new ArrayList<HDD>();
        ArrayList<RAM> rams = new ArrayList<RAM>();
        ArrayList<SSD> ssds = new ArrayList<SSD>();

        for (File fileEntry : depozit.listFiles()) {

            CSVHelper CSV = new CSVHelper(fileEntry);
            allList = CSV.read();

            if (fileEntry.getName().toUpperCase().equals("CPU.CSV")) {

                for (int i = 0; i < allList.size(); i++)
                    if (allList.get(i) != null) {
                        LocalDate buyDate = LocalDate.parse(allList.get(i).get(2));
                        int price, stock, cores, threads, lithography, maxMem;
                        double freq, turbofreq;
                        freq = Double.parseDouble(allList.get(i).get(6));
                        turbofreq = Double.parseDouble(allList.get(i).get(7));
                        price = Integer.parseInt(allList.get(i).get(0));
                        stock = Integer.parseInt(allList.get(i).get(1));
                        cores = Integer.parseInt(allList.get(i).get(8));
                        threads = Integer.parseInt(allList.get(i).get(9));
                        lithography = Integer.parseInt(allList.get(i).get(10));
                        maxMem = Integer.parseInt(allList.get(i).get(12));


                        cpus.add(new CPU(price, stock, buyDate, allList.get(i).get(3), allList.get(i).get(4), allList.get(i).get(5), freq, turbofreq, cores, threads, lithography, false, maxMem));

                    }


            }

            if (fileEntry.getName().toUpperCase().equals("HDD.CSV")) {


                for (int i = 0; i < allList.size(); i++)
                    if (allList.get(i) != null) {
                        LocalDate buyDate = LocalDate.parse(allList.get(i).get(2));
                        float price = Float.parseFloat(allList.get(i).get(0));
                        int stock = Integer.parseInt(allList.get(i).get(1));
                        int capacity = Integer.parseInt(allList.get(i).get(5));
                        int cache = Integer.parseInt(allList.get(i).get(6));
                        int rpm = Integer.parseInt(allList.get(i).get(7));

                        hdds.add(new HDD(price, stock, buyDate, allList.get(i).get(3), allList.get(i).get(4), capacity, cache, rpm));
                    }
            }
            if (fileEntry.getName().toUpperCase().equals("RAM.CSV")) {


                for (int i = 0; i < allList.size(); i++)
                    if (allList.get(i) != null) {
                        LocalDate buyDate = LocalDate.parse(allList.get(i).get(2));
                        float price = Float.parseFloat(allList.get(i).get(0));
                        int size = Integer.parseInt(allList.get(i).get(7));
                        float voltage = Float.parseFloat(allList.get(i).get(8));
                        int stock = Integer.parseInt(allList.get(i).get(1));

                        rams.add(new RAM(price, stock, buyDate, allList.get(i).get(3), allList.get(i).get(4), allList.get(i).get(5), allList.get(i).get(6), size, voltage));
                    }
            }
            if (fileEntry.getName().toUpperCase().equals("SSD.CSV")) {


                for (int i = 0; i < allList.size(); i++)
                    if (allList.get(i) != null) {
                        LocalDate buyDate = LocalDate.parse(allList.get(i).get(2));
                        float price = Float.parseFloat(allList.get(i).get(0));
                        int stock = Integer.parseInt(allList.get(i).get(1));
                        int capacity = Integer.parseInt(allList.get(i).get(5));
                        int cache = Integer.parseInt(allList.get(i).get(7));

                        ssds.add(new SSD(price, stock, buyDate, allList.get(i).get(3), allList.get(i).get(4), capacity, allList.get(i).get(6), cache));
                    }
            }

        }
        //End of reading csv

        int productSize = cpus.size() + rams.size() + hdds.size() + ssds.size();
        Product[] products = new Product[productSize];

        int nr = cpus.size();
        for (int i = 0; i < nr; i++)
            products[i] = new CPU(cpus.get(i));
        nr += rams.size();
        for (int i = nr - rams.size(), j = 0; i < nr; i++, j++)
            products[i] = new RAM(rams.get(j));
        nr += hdds.size();
        for (int i = nr - hdds.size(), j = 0; i < nr; i++, j++)
            products[i] = new HDD(hdds.get(j));
        nr += ssds.size();
        for (int i = nr - ssds.size(), j = 0; i < nr; i++, j++)
            products[i] = new SSD(ssds.get(j));

        //Sorting the array
        Arrays.sort(products, Comparator.comparing(Product::getManufacturer));
        while (1 == 1) {
            // Din motive GDPR nu retinem datele clientilor
            Customer pers = new Customer();
            ArrayList<Product> cos = new ArrayList<Product>();



            System.out.println("Clientul nr. " + pers.getTotal());
            pers.read();
            while ( 1 == 1 ) {

                UserOptions userOptions = new UserOptions();
//                System.out.println("Inainte de conexiune");

                System.out.println("Dupa de conexiune");
                System.out.println("Search menu:");
                System.out.println("1. Search CPUs");
                System.out.println("2. Search HDDs");
                System.out.println("3. Search SSDs");
                System.out.println("4. Search RAMs");
                System.out.println("5. Search GPUs");
                System.out.println("6. Show CPUs");
                System.out.println("7. Show HDDs");
                System.out.println("8. Verificare stoc produs dupa producator ");
                System.out.println("9. Show SSD");
                System.out.println("10. Introdu un produs de cumparat");
                System.out.println("11. Exit");
                System.out.println("12. Urmatorul client");
                System.out.println("13. Creaza tablelul CPUs (CREATE)");
                System.out.println("14. Schimba pretul tuturor CPUs in 100 (UPDATE)");
                System.out.println("15. Arata toate produsele CPU cu cateva informatii(READ)");
                System.out.println("16. Sterge o intrare din CPU(DELETE)");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Optiunea este:");
                int option = scanner.nextInt();


                if (option == 1)
                    userOptions.searchCPU(products);
                if (option == 2)
                    userOptions.searchHDD(products);
                if (option == 3)
                    userOptions.searchSSD(products);
                if (option == 4)
                    userOptions.searchRAM(products);
                if (option == 5)
                    userOptions.searchGPU(products);
                if (option == 6) {
                    for (int i = 0; i < cpus.size(); i++) {
                        System.out.println("Produsul: " + (i + 1) + "\n");
                        cpus.get(i).GeneralInfo();
                    }
                }
                if (option == 7) {
                    for (int i = 0; i < hdds.size(); i++) {
                        System.out.println("Produsul: " + (i + 1) + "\n");
                        hdds.get(i).GeneralInfo();
                    }
                }
                if (option == 8)
                    userOptions.stocProdus(products);
                if (option == 9){
                    for (int i = 0; i < ssds.size(); i++) {
                        System.out.println("Produsul: " + (i + 1) + "\n");
                        ssds.get(i).GeneralInfo();
                    }
                }



                if (option == 10){
                    for (int i = 0; i < products.length; i++) {
                        if (products[i].getStock() > 0) {
                            System.out.println("Produsul: " + (i + 1) + "\n ------------------- \n");
                            products[i].GeneralInfo();
                        }

                    }
                    System.out.println("Alegeti nr produsului va rog: ");
                    Scanner dummy = new Scanner(System.in);
                    String nrString = dummy.nextLine();
                    int nrInt=Integer.parseInt(nrString);
                    if ( products[nrInt - 1].getStock() <= 0 ){
                        System.out.println("Ne pare rau dar acest produs nu mai este pe stock: " );
                        TimeUnit.SECONDS.sleep(2);
                        continue;
                    }
                    System.out.println("Cate bucati?: ");
                    String nrString2 = dummy.nextLine();
                    int nrInt2=Integer.parseInt(nrString2);
                    if ( products[nrInt - 1].getStock() < nrInt2 ){
                        System.out.println("Ne pare rau dar mai avem doar " + products[nrInt - 1].getStock() + " bucati pe stock: " );
                        TimeUnit.SECONDS.sleep(2);
                        continue;
                    }
                    cos.add(products[nrInt - 1]);
                    products[nrInt - 1].cumparare(nrInt2);
                }
                if (option == 11) {
                    System.exit(1);
                }
                if (option == 12){
                    System.out.println("Cosul de cumparaturi: ");
                    for (int i = 0; i < cos.size(); i++) {
                        System.out.println("Produsul: " + (i + 1) + "\n");
                        cos.get(i).GeneralInfo();
                    }
                    int pretTot = 0;
                    for (int i = 0; i < cos.size(); i++) {
                        pretTot += cos.get(i).getPrice();
                    }
                    System.out.println("Pret cos: " + pretTot);
                    System.out.println("Say goodbye to " + pers.getName());
                    break;
                }

                if (option > 16 || option < 1)
                    System.out.println("Invalid");
                if(option == 13){
                    try{
                        userOptions.createCPUS();
                        TimeUnit.SECONDS.sleep(3);
                    } catch(SQLException e) {
                        System.out.println("Eroarea este:" + e);
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
                if(option == 14){
                    try{
                        userOptions.updateCPUS();
                        TimeUnit.SECONDS.sleep(3);
                    } catch(SQLException e) {
                        System.out.println("Eroarea este:" + e);
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
                if(option == 15){
                    try{
                        userOptions.readCPUS();
                        TimeUnit.SECONDS.sleep(3);
                    } catch(SQLException e) {
                        System.out.println("Eroarea este:" + e);
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
                if(option == 16){
                    try{
                        userOptions.deleteCPUS();
                        TimeUnit.SECONDS.sleep(3);
                    } catch(SQLException e) {
                        System.out.println("Eroarea este:" + e);
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
                pressAnyKeyToContinue();
            }

        }




    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("Type back to continue...(not case sensitive)");
        Scanner dummy = new Scanner(System.in);
        String back = dummy.nextLine();
    }
}
