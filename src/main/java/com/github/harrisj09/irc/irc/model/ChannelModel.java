package com.github.harrisj09.irc.irc.model;

import com.github.harrisj09.irc.irc.model.data.Channel;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChannelModel {
    private HashMap<String, Channel> channels = new HashMap<>();


    public Channel addChannel(String name) {
        Channel channel = new Channel(name);
        channels.put(name, channel);
        return channel;
    }

    public Channel getChannel(String channelId) {
        return channels.get(channelId);
    }
}
