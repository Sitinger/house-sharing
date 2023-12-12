package org.example.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum ResponseMessage {
    CLIENT_NOT_FOUND("Client not found"),
    INCORRECT_PASSWORD("Incorrect password"),
    LOGIN_ALREADY_EXISTS("Login already exists"),
    HOUSES_NOT_FOUND("Houses not found"),
    NO_DIFFERENCE_BETWEEN_DATA("No difference between new and old data"),
    HOUSE_NOT_FOUND("House not found"),
    DELETED_SUCCESSFULLY("Deleted successfully");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getJSON() {
        class MessageObject {
            public final String message;
            MessageObject(String message) {
                this.message = message;
            }
        }

        try {
            return new ObjectMapper().writeValueAsString(new MessageObject(this.message));
        }
        catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
