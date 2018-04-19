package com.m3c.an.display;

import com.m3c.an.sorters.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DisplayManagerTest {

    @Test
    public void displayUnsortedArray() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut((new PrintStream(outContent)));
        Sorter sorter = mock(Sorter.class);
        when(sorter.toString()).thenReturn("merge");
        DisplayManager displayManager = new DisplayManager();
        displayManager.displayUnsortedArray(sorter, new int[] {5, 3, 1, 2, 4});
        String expectedOutput = "Sort using: merge" + "\r\n" + "Unsorted Array: [5, 3, 1, 2, 4]\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void displaySorted() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut((new PrintStream(outContent)));
        DisplayManager displayManager = new DisplayManager();
        displayManager.displaySorted(new int[] {1, 2, 3, 4, 5}, 1);
        String expectedOutput = "Sorted Array: [1, 2, 3, 4, 5]" + "\r\n" + "Time taken: 1\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void displayExceptionMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut((new PrintStream(outContent)));
        DisplayManager displayManager = new DisplayManager();
        displayManager.displayExceptionMessage("Exception message");
        String expectedOutput = "Exception message\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}