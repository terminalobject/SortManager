package com.m3c.an.controller;
import com.m3c.an.sorters.BinarySort;
import com.m3c.an.sorters.BubbleSort;
import com.m3c.an.sorters.MergeSort;
import com.m3c.an.sorters.Sorter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    public static Sorter getInstance() throws SortManagerException{
        try (FileReader fr = new FileReader("resources/factory.properties")) {
            Properties properties = new Properties();
            properties.load(fr);
            String sorter = properties.getProperty("sorter");
            switch (sorter) {
                    case "bubble":
                        return new BubbleSort();
                    case "merge":
                        return new MergeSort();
                case "binary":
                        return new BinarySort();
                    default:
                        SortManagerException sme = new SortManagerException();
                        sme.setMessage("Sorry, this sorter type is not available.");
                        throw sme;
            }
        } catch (IOException e) {
            throw new SortManagerException();
        }
    }
}
