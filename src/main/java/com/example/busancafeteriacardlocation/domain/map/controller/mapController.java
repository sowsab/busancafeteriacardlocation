package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapController {
    
    @GetMapping("/")
    public String getMainPage () {

        return "main";
    }

}
