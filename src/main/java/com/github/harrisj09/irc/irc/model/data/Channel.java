package com.github.harrisj09.irc.irc.model.data;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String channelName;
    private List<Message> messageList;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.messageList = new ArrayList<>(50);
    }

/*    public String chatRoom() {
        String result = messageList.stream()
                .map(n -> n)
        return "";
    }*/
}
