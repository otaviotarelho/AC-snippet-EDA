package edu.otaviotarelho.consumer;

public enum Events {

    SIGNUP_CONFIRMATION("SIGNUP_CONFIRMATION"),
    CHANGE_ADDRESS_CONFIRMATION("CHANGE_ADDRESS_CONFIRMATION");

    public String event;

    Events(String event) {
        this.event = event;
    }
}
