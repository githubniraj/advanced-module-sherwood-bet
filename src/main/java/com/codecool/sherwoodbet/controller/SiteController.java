package com.codecool.sherwoodbet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by patrik on 2017.02.01..
 */
@Controller
public class SiteController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/game")
    public String game() {
        return "game";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }


}
