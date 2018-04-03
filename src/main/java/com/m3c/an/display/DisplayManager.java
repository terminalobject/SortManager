package com.m3c.an.display;

import com.m3c.an.controller.SortManagerException;
import com.m3c.an.sorters.Sorter;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManager {

        public void displayUnsortedArray(Sorter sorter, int[] arrUnsorted) {
            System.out.println("Sort using: " + sorter.toString());
            System.out.println("Unsorted Array: " + Arrays.toString(arrUnsorted));
        }

        public void displaySorted(int[] arrSorted, long time) {
            DecimalFormat df = new DecimalFormat("###,###.####");
            System.out.println("Sorted Array: " + Arrays.toString(arrSorted));
            System.out.println("Time taken: " + df.format(time));
        }

        public void displayExceptionMessage(String message) {
            System.out.println(message);


    }

}
