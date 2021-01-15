package com.github.harrisj09.irc.irc.admin;

import com.github.harrisj09.irc.irc.model.ChannelModel;
import com.github.harrisj09.irc.irc.model.data.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AddChannel {

    @Autowired
    ChannelModel channelModel;

    @PostMapping("createchannel/{channelId}")
    public ResponseEntity<String> createChannel(@PathVariable String channelId) {
        Channel channel = channelModel.getChannel(channelId);
        if(channel == null) {
            return ResponseEntity.ok(channelModel.addChannel(channelId).getChannelName());
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
