package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.busancafeteriacardlocation.domain.map.service.InitService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Value("${kakao.map.api-key}")
    private String kakaoApiKey;

    private final InitService initService;

    @GetMapping("/")
    public String getMainPage(Model model) {

        model.addAttribute("kakaoMapApiKey", kakaoApiKey);
        // model.addAttribute("DTO", initService.getLocations());

        return "main";
    }

}
