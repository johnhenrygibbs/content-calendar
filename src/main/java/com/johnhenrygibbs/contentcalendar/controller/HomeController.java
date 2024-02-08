package com.johnhenrygibbs.contentcalendar.controller;

import com.johnhenrygibbs.contentcalendar.config.ContentCalendarProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;
import java.util.Map;

@RestController
public class HomeController {

//    @Value("${cc.welcomeMessage: Default Welcome Message}")
//    private String welcomeMessage;
//
//    @Value("{cc.about}")
//    private String about;

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
        return properties;
    }

}
