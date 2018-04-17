package com.m3c.an.controller;

import com.m3c.an.display.DisplayManager;
import com.m3c.an.sorters.Sorter;
import org.apache.log4j.PropertyConfigurator;
import java.util.Random;

public class SortManager {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Starter.class);

    public void sortArray() {
        PropertyConfigurator.configure("resources/log4j.properties");
        logger.info("Start");
        DisplayManager displayManager = new DisplayManager();
        try {
            Sorter sorter = SortFactory.getInstance("factory.properties");
            int[] arrayToSort = createArray(100);

            displayManager.displayUnsortedArray(sorter, arrayToSort);
            long start = System.nanoTime();
            int[] sortedArray = sorter.sortArray(arrayToSort);
            long end = System.nanoTime();
            displayManager.displaySorted(sortedArray, (end - start));
            logger.info("Sorting time: " + (end-start));
        } catch (SortManagerException sme) {
            displayManager.displayExceptionMessage(sme.getMessage());
        }
        logger.info("Finish");
    }

    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10) + 1;
        }
        return unsortedArray;
    }
}
