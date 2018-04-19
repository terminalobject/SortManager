package com.m3c.an.sorters;

public class Node {
    private int value; //Should have been final, but I needed to change it in order to implement deletion
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node leftChild) {
       this.left = leftChild;
    }

    public void setRight(Node rightChild) {
        this.right = rightChild;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }
}
