package com.m3c.an.sorters;

public class Node {
    final private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
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
