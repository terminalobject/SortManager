package com.m3c.an.controller;

import org.junit.Test;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;

public class SortManagerTest {

    @Test
    public void sortArray() {
        SortManager sortManager = new SortManager();
        sortManager.sortArray();
    }
}