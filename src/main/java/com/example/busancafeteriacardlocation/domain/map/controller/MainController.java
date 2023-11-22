package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${kakao.map.api-key}")
    private String kakaoApiKey;

    @GetMapping("/")
    public String getMainPage(Model model) {


        model.addAttribute("kakaoMapApiKey", kakaoApiKey);

        return "main";
    }

}
