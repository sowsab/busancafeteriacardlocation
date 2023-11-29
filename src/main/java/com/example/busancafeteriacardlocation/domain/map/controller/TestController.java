package com.example.busancafeteriacardlocation.domain.map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busancafeteriacardlocation.domain.map.dto.APIResponseDTO;
import com.example.busancafeteriacardlocation.domain.map.service.MainService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {
    
    private final MainService mainService;
    
    @GetMapping("/test")
    public APIResponseDTO getTest() {
        
        return mainService.getLocations();

    }
}
