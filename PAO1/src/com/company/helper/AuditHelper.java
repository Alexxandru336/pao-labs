package com.company.helper;

import java.io.*;
import java.time.LocalDate;
import com.opencsv.CSVWriter;

public class AuditHelper {
    public static void printCall(String callerName, LocalDate callTime)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File("Audit/AuditFile.csv");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            if (bufferedReader.readLine() == null) {
                FileWriter outputfile = new FileWriter(file);
                CSVWriter writer = new CSVWriter(outputfile);
                // adding header to csv if null
                String[] header = {"nume_actiune", "timestamp"};
                writer.writeNext(header);

                String[] data = {callerName, callTime.toString()};
                writer.writeNext(data);

                writer.flush();
                writer.close();
            }
            else
            {
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);

                String[] data = {callerName, callTime.toString()};
                writer.writeNext(data);

                writer.flush();
                writer.close();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
