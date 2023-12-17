package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.busancafeteriacardlocation.domain.map.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Value("${kakao.map.api-key}")
    private String kakaoApiKey;

    private final MainService mainService;

    @GetMapping("/")
    public String getMainPage(Model model) {

        model.addAttribute("kakaoMapApiKey", kakaoApiKey);
        model.addAttribute("DTO", mainService.getMapData());

        return "main";
    }

    @GetMapping("/search/{keyword}")
    public String getSearchPage(Model model, @PathVariable String keyword) {

        model.addAttribute("kakaoMapApiKey", kakaoApiKey);
        model.addAttribute("DTO", mainService.searchGetMapData(keyword));

        return "search";
    }

}
