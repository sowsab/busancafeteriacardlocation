package com.example.busancafeteriacardlocation.domain.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.busancafeteriacardlocation.domain.auth.dto.ResGetUpdateDataDTO;
import com.example.busancafeteriacardlocation.domain.auth.dto.ResGetUpdateDataDTO.ReqGetUpdateDataDTO;
import com.example.busancafeteriacardlocation.domain.common.dto.LoginDTO;
import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;
import com.example.busancafeteriacardlocation.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;

    // 회원정보 불러오기

    public ResGetUpdateDataDTO getUpdateUserData(HttpSession session) {

        LoginDTO sessionDTO = (LoginDTO) session.getAttribute("dto");

        Optional<UserEntity> userEntityOptional = userRepository.findById(sessionDTO.getUser().getId());

        UserEntity userEntity = userEntityOptional.get();

        return new ResGetUpdateDataDTO(ReqGetUpdateDataDTO.convert(userEntity));

    }

}
