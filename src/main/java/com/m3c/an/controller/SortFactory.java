package com.m3c.an.controller;

import com.m3c.an.sorters.BubbleSort;
import com.m3c.an.sorters.MergeSort;
import com.m3c.an.sorters.Sorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    public static Sorter getInstance(){
        try {
            Properties properties = new Properties();
                properties.load(new FileReader("resources/factory.properties"));
                String sorter = properties.getProperty("sorter");
                switch (sorter) {
                    case "bubble":
                        return new BubbleSort();
                    case "merge":
                        return new MergeSort();
                    default:
                    // TODO: throw new exception
            }
            System.out.println("SORTER: " + sorter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
