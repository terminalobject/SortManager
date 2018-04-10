package com.m3c.an.sorters;

public class BinarySort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BTree bTree = new BTree(arrayToSort);
        int[] sortedArray = bTree.getSortedTreeAsc().stream().mapToInt(i->i).toArray();
        return sortedArray;
    }

}
