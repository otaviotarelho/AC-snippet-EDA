package edu.otaviotarelho;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.logging.Logger;

public class UserService{

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public User updateUser(User user, Address address){
        user.updateUserAddress(address);

        publishEvent(Events.CHANGE_ADDRESS_CONFIRMATION, user.getEmail());

        return user;
    }

    private void publishEvent(Events event, String emailAddress){

        JsonObject object = new JsonObject();
        object.addProperty("event", event.event);
        object.addProperty("emailAddress", emailAddress);

        String JSON = new Gson().toJson(object);

        MessageQueue.sendEvent(JSON);

        logger.info("UPDATING USER ADDRESS WITH " + JSON);
    }
}
