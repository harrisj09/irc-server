package com.github.harrisj09.irc.irc.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class KickUser {

    @GetMapping("/kick/{user}")
    public ResponseEntity<String> kickUser(@PathVariable String user, HttpServletRequest request) {

        return new ResponseEntity<>("you've been kicked", HttpStatus.ACCEPTED);
    }
}
