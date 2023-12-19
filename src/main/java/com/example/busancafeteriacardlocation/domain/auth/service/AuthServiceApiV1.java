package com.example.busancafeteriacardlocation.domain.auth.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.busancafeteriacardlocation.domain.auth.dto.ReqJoinDTO;
import com.example.busancafeteriacardlocation.domain.auth.dto.ReqLoginDTO;
import com.example.busancafeteriacardlocation.domain.auth.dto.ReqUpdateDTO;
import com.example.busancafeteriacardlocation.domain.common.dto.LoginDTO;
import com.example.busancafeteriacardlocation.domain.common.dto.ResponseDTO;
import com.example.busancafeteriacardlocation.domain.common.exception.BadRequestException;
import com.example.busancafeteriacardlocation.domain.common.exception.UnauthorizedException;
import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;
import com.example.busancafeteriacardlocation.model.user.entity.UserRoleEntity;
import com.example.busancafeteriacardlocation.model.user.repository.UserRepository;
import com.example.busancafeteriacardlocation.model.user.repository.UserRoleRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceApiV1 {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    // 로그인 기능 구현

    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("존재하지않은 사용자 입니다");
        }

        UserEntity userEntity = userEntityOptional.get();

        if (!userEntity.getPw().equals(dto.getUser().getPw())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다");
        }

        session.setAttribute("dto", LoginDTO.convert(userEntity));

        return new ResponseEntity<>(ResponseDTO.builder()
                .code(0)
                .message("로그인에 성공 했습니다")
                .build(),
                HttpStatus.OK);

    }

    // 회원가입 기능 구현

    public ResponseEntity<?> join(ReqJoinDTO dto) {

        if (!dto.getUser().getPw().equals(dto.getUser().getCheckpw())) {
            throw new BadRequestException("비밀번호를 확인해 주세요");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        if (userEntityOptional.isPresent()) {
            throw new BadRequestException("이미 존재하는 아이디 입니다");
        }

        userEntityOptional = userRepository.findByEmail(dto.getUser().getEmail());

        if (userEntityOptional.isPresent()) {
            throw new BadRequestException("이미 존재하는 이메일 입니다");
        }

        userRepository.save(UserEntity.builder()
                .id(dto.getUser().getId())
                .email(dto.getUser().getEmail())
                .pw(dto.getUser().getPw())
                .build());

        Optional<UserEntity> joinedUserEntityOptional = userRepository.findById(dto.getUser().getId());

        UserEntity userEntity = joinedUserEntityOptional.get();

        userRoleRepository.save(UserRoleEntity.builder()
                .userEntity(UserEntity.builder()
                        .idx(userEntity.getIdx())
                        .build())
                .role("USER")
                .build());

        return new ResponseEntity<>(ResponseDTO.builder()
                .code(0)
                .message("회원가입에 성공했습니다.")
                .build(), HttpStatus.OK);
    }

    // 회원정보 업데이트 구현

    public ResponseEntity<?> update(ReqUpdateDTO dto, HttpSession session) {

        LoginDTO loginDTO = (LoginDTO) session.getAttribute("dto");

        if (loginDTO == null) {
            throw new UnauthorizedException("로그인 하지 않았습니다");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findByIdx(loginDTO.getUser().getIdx());

        UserEntity userEntity = userEntityOptional.get();

        if (!dto.getUser().getCheckpw().equals(userEntity.getPw())) {
            throw new BadRequestException("확인용 비밀번호를 확인해주세요");
        }

        if (!dto.getUser().getId().equals(userEntity.getId())) {
            Optional<UserEntity> userEntityOptionalCheck = userRepository.findById(dto.getUser().getId());

            if (userEntityOptionalCheck.isPresent()) {
                throw new BadRequestException("아이디가 중복 되었습니다");
            }
        }

        if (!dto.getUser().getEmail().equals(userEntity.getEmail())) {
            Optional<UserEntity> userEntityOptionalCheck = userRepository
                    .findByEmail(dto.getUser().getEmail());

            if (userEntityOptionalCheck.isPresent()) {
                throw new BadRequestException("이메일이 중복 되었습니다");
            }
        }

        userRepository.save(UserEntity.builder()
                .idx(userEntity.getIdx())
                .id(dto.getUser().getId())
                .email(dto.getUser().getEmail())
                .pw(dto.getUser().getPw())
                .build());

        session.invalidate();

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("회원정보 수정에 성공했습니다")
                        .build(),
                HttpStatus.OK);

    }

}
