package edu.otaviotarelho.consumer;

public class EventInformation {

    private Events event;
    private String emailAddress;

    public EventInformation(Events event, String emailAddress) {
        this.event = event;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "EventInformation{" +
                "event=" + event +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
