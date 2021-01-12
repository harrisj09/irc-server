package com.github.harrisj09.irc.irc.model;

import com.github.harrisj09.irc.irc.model.data.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserModel {
    private List<User> users;

    public UserModel() {
        this.users = new ArrayList<>();
    }

    // When user connects check
}
