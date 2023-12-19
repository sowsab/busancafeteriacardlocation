package com.example.busancafeteriacardlocation.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.busancafeteriacardlocation.domain.auth.service.AuthService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @GetMapping("/auth/login")
    public String login(Model model) {

        return "auth/login";
    }

    @GetMapping("/auth/join")
    public String join(Model model) {

        return "auth/join";
    }

    @GetMapping("/auth/update")
    public String update(Model model, HttpSession session) {

        if (session.getAttribute("dto") == null) {
            return "redirect:/";
        }
        
        model.addAttribute("dto", authService.getUpdateUserData(session));

        return "auth/update";
    }
}
