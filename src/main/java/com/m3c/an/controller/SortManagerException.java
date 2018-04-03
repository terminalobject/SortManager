package com.m3c.an.controller;

public class SortManagerException extends Exception {

    private String newMessage;

    @Override
    public String getMessage() {
        return "Could not run the sorter with the selected type.";
    }

    public void setMessage(String newMessage) {
        this.newMessage = newMessage;
    }
}
