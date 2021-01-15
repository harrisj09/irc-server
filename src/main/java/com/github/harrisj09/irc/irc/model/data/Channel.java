package com.github.harrisj09.irc.irc.model.data;

import java.util.LinkedList;
import java.util.List;

public class Channel {

    private String channelName;
    private LinkedList<Message> messageList;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.messageList = new LinkedList<>() {
            @Override
            public boolean add(Message message) {
                if(this.size() > 50) {
                    this.removeLast();
                }
                return super.add(message);
            }
        };
    }

    public String getChannelName() {
        return channelName;
    }

    public void addMessage(String user, String message, String id) {
        messageList.add(new Message(user, message, id));
    }

    public List<Message> getLatestMessages() {
        return messageList;
    }

/*    public String chatRoom() {
        String result = messageList.stream()
                .map(n -> n)
        return "";
    }*/
}
