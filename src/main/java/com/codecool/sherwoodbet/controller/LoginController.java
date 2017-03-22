package com.codecool.sherwoodbet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csyk on 2017.02.15..
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(SiteController.class);

    @RequestMapping("/welcome")
    @ResponseBody
    public Map login() {
        Map response = new HashMap<String, Boolean>();
        response.put("login_successful", true);
        log.info(response.toString());
        return response;
    }

    @RequestMapping("/notsuccessful")
    @ResponseBody
    public Map failure() {
        Map response = new HashMap<String, Boolean>();
        response.put("login_successful", false);
        log.info(response.toString());
        return response;
    }
}
