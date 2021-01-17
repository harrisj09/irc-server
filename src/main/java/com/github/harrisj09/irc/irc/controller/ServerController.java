package com.github.harrisj09.irc.irc.controller;

import com.github.harrisj09.irc.irc.model.ChannelModel;
import com.github.harrisj09.irc.irc.model.ChatModel;
import com.github.harrisj09.irc.irc.model.UserModel;
import com.github.harrisj09.irc.irc.model.data.Channel;
import com.github.harrisj09.irc.irc.model.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private ChannelModel channelModel;
    @Autowired
    private ChatModel chatModel;
    @Autowired
    private UserModel userModel;

    @GetMapping("connect/{id}")
    public ResponseEntity<Collection<String>> connect(@PathVariable String id, HttpServletRequest request) {
        if (userModel.getUsers().contains(id)) {
            // User already exists
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ArrayList<>(channelModel.getChannels().keySet()), HttpStatus.OK);
    }


    @GetMapping("channels/{channelId}/latest")
    public ResponseEntity<List<Message>> getLatestChannelMessages(@PathVariable String channelId) {
        Channel channel = channelModel.getChannel(channelId);
        if(channel == null) {
            // if this is returned have the user delete the channel
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(channel.getLatestMessages(), HttpStatus.OK);
    }


    // TODO Fix this and move it to a different class
    @PostMapping("channels/{channelId}")
    public ResponseEntity<String> createChannel(@PathVariable String channelId) {
        Channel channel = channelModel.getChannel(channelId);
        if(channel == null) {
            return ResponseEntity.ok(channelModel.addChannel(channelId).getChannelName());
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("channels/{channelId}/{user}/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String channelId, @PathVariable String user, @PathVariable String message) {
        Channel channel = channelModel.getChannel(channelId);
        if(channel == null) {
            // if this is returned have the user delete the channel
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        channel.addMessage(user, message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
