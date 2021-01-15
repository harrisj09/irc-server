package com.github.harrisj09.irc.irc.model.data;

public class Message {


    private String user;
    private String message;
    private String id;

    public Message(String user, String message, String id) {
        this.user = user;
        this.message = message;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
