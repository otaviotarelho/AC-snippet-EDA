package edu.otaviotarelho.consumer;

public class EventInformation {

    private Events event;
    private String emailAddress;

    public EventInformation(Events event, String emailAddress) {
        this.event = event;
        this.emailAddress = emailAddress;
    }
}
