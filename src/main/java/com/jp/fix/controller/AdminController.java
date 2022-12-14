package com.jp.fix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.fix.FixApplication;
import com.jp.fix.MessageProcessor;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    MessageProcessor messageProcessor;

    @GetMapping
    public String home() {

        messageProcessor.sendSampleMsg();

        return "Admin version : " + FixApplication.appVersion;
    }

    @GetMapping("start")
    public String start() {
        return "Starting...";
    }
}
