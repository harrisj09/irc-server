package com.github.harrisj09.irc.irc.model.data;

import java.net.InetAddress;

public class User {

    private String userName;
    private InetAddress ip;

    public User(String userName, InetAddress ip) {
        this.userName = userName;
        this.ip = ip;
    }
}
