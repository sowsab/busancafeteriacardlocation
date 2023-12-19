package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busancafeteriacardlocation.domain.map.dto.APIRequestDTO;
import com.example.busancafeteriacardlocation.domain.map.service.InitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {
    
    // api가 동작하는지 테스트 할때 사용, mainsevice는 현재 InitService로 바뀜

    private final InitService mainService;
    
    // @GetMapping("/test")
    // public APIRequestDTO getTest() {
        
    //     return mainService.getLocations();

    // }
}
