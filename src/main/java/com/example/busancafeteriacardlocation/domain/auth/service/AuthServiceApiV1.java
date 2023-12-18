package com.example.busancafeteriacardlocation.domain.auth.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.busancafeteriacardlocation.domain.auth.dto.ReqLoginDTO;
import com.example.busancafeteriacardlocation.domain.common.dto.LoginDTO;
import com.example.busancafeteriacardlocation.domain.common.dto.ResponseDTO;
import com.example.busancafeteriacardlocation.domain.common.exception.BadRequestException;
import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;
import com.example.busancafeteriacardlocation.model.user.repository.UserRepository;
import com.example.busancafeteriacardlocation.model.user.repository.UserRoleRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceApiV1 {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("존재하지않은 사용자 입니다");
        }

        UserEntity userEntity = userEntityOptional.get();

        if (userEntity.getPw().equals(dto.getUser().getPw())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다");
        }

        session.setAttribute("dto", LoginDTO.convert(userEntity));

        return new ResponseEntity<>(ResponseDTO.builder()
                .code(0)
                .message("로그인에 성공 했습니다")
                .build(),
                HttpStatus.OK);

    }

}
