package com.m3c.an.display;

import com.m3c.an.sorters.Sorter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DisplayManagerTest {

    @Test
    public void displayUnsortedArray() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut((new PrintStream(outContent)));
        Sorter sorter = mock(Sorter.class);
    }

    @Test
    public void displaySorted() {
    }

    @Test
    public void displayExceptionMessage() {
    }
}