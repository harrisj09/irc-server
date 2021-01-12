package com.github.harrisj09.irc.irc.controller;

import com.github.harrisj09.irc.irc.model.ChannelModel;
import com.github.harrisj09.irc.irc.model.ChatModel;
import com.github.harrisj09.irc.irc.model.UserModel;
import com.github.harrisj09.irc.irc.model.data.Channel;
import com.github.harrisj09.irc.irc.model.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String connect(@PathVariable String id, HttpServletRequest request) {
        // check if theres already someone with a username
        // if not return users in server
        // and channel names

        return id;
    }

    @GetMapping("channels/{channelId}/latest")
    public ResponseEntity<List<Message>> getLatestChannelMessages(@PathVariable String channelId) {
        Channel channel = channelModel.getChannel(channelId);
        if(channel == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(channel.getLatestMessages(), HttpStatus.OK);
    }

    @PostMapping("channels/{channelId}")
    public ResponseEntity<String> createChannel(@PathVariable String id) {
        Channel channel = channelModel.getChannel(id);
        if(channel == null) {
            return ResponseEntity.ok(channelModel.addChannel(id).getChannelName());
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
