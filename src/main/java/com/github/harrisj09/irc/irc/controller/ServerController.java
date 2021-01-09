package com.github.harrisj09.irc.irc.controller;

import com.github.harrisj09.irc.irc.model.data.Channel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ServerController {

    HashMap<String, Channel> channels;

    @GetMapping("/connect")
    public String test() {
        /*
        It'll check your user name
        If it doesn't come up in the list of usernames already registered it sends you this info
        {channelName, urlToChannel}
        {urlToUsersList}
        the url to channel allows you to grab the messages of each one
         */
        return "<h1> Hello World </h1>";
    }
}
