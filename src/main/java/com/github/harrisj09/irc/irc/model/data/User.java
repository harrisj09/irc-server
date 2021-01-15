package com.github.harrisj09.irc.irc.model.data;

import java.net.InetAddress;

public class User {

    private String userName;
    private String ipAddress;
    private InetAddress ip;

    public User(String userName, String ipAddress, InetAddress ip) {
        this.userName = userName;
        this.ipAddress = ipAddress;
        this.ip = ip;
    }
}
