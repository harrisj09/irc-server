package com.github.harrisj09.irc.irc.controller;

import com.github.harrisj09.irc.irc.controller.server.ChannelController;
import com.github.harrisj09.irc.irc.controller.server.ChatController;
import com.github.harrisj09.irc.irc.controller.server.UserController;
import com.github.harrisj09.irc.irc.model.ChannelModel;
import com.github.harrisj09.irc.irc.model.ChatModel;
import com.github.harrisj09.irc.irc.model.data.Channel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class ServerController {

    private HashMap<String, Channel> channels;
    private ChannelModel channelController;
    private ChatModel chatController;
    private UserController userController;

    @GetMapping("/connect/{id}")
    public String test(@PathVariable String id, HttpServletRequest request) {

        /*
        It'll check your user name
        If it doesn't come up in the list of usernames already registered it sends you this info
        {channelName, urlToChannel}
        {urlToUsersList}
        the url to channel allows you to grab the messages of each one
         */
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        return id;
    }
}
