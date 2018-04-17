package com.m3c.an.controller;

import com.m3c.an.sorters.MergeSort;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortFactoryTest {
    SortFactory sortFactory = new SortFactory();

    @Test(expected = SortManagerException.class)
    public void sortFactoryTestException() throws SortManagerException {
        Assert.assertTrue(sortFactory.getInstance("testfactoryexception.properties").getClass().equals(new MergeSort().getClass()));
    }

    @Test
    public void sortFactoryTest() throws SortManagerException {
        Assert.assertTrue(sortFactory.getInstance("testfactory.properties").getClass().equals(new MergeSort().getClass()));
    }

}