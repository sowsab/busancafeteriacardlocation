package com.example.busancafeteriacardlocation.domain.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busancafeteriacardlocation.domain.auth.dto.ReqJoinDTO;
import com.example.busancafeteriacardlocation.domain.auth.dto.ReqLoginDTO;
import com.example.busancafeteriacardlocation.domain.auth.dto.ReqUpdateDTO;
import com.example.busancafeteriacardlocation.domain.auth.service.AuthServiceApiV1;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {
    
    private final AuthServiceApiV1 authServiceApiV1;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqLoginDTO reqLoginDTO, HttpSession session) {
        return authServiceApiV1.login(reqLoginDTO, session);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody ReqJoinDTO reqJoinDTO) {
        return authServiceApiV1.join(reqJoinDTO);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqUpdateDTO reqUpdateDTO, HttpSession session) {
        return authServiceApiV1.update(reqUpdateDTO, session);
    }

}
