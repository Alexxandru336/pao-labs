package com.company.helper;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.List;


public class CSVHelper {


    private static File csvFile;

    public CSVHelper(File csvName) {
        csvFile = csvName;
    }

    public ArrayList<List<String>> read() throws Exception {
        ArrayList<List<String>> dataArray = new ArrayList<>();
        Scanner scanner = new Scanner(csvFile);
        List<String> line;
        scanner.nextLine();
        while (scanner.hasNext()) {
            line = parseLine(scanner.nextLine());
            dataArray.add(line);
        }
        scanner.close();
        return dataArray;
    }


    public static List<String> parseLine(String csvLine) {
        List<String> rez = new ArrayList<>();

        char separator = ',';

        if (csvLine == null && csvLine.isEmpty()) {
            return rez;
        }

        StringBuffer colItem = new StringBuffer();


        char[] chars = csvLine.toCharArray();

        for (char ch : chars) {

            if (ch == separator) {
                rez.add(colItem.toString());
                colItem = new StringBuffer();
            } else if (ch == '\n') {
                break;
            } else {
                colItem.append(ch);
            }
        }

        rez.add(colItem.toString());
        return rez;
    }
}
