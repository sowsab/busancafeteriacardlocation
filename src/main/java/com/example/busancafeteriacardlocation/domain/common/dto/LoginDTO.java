package com.example.busancafeteriacardlocation.domain.common.dto;

import java.util.List;

import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class LoginDTO {

    private User user;

    public static LoginDTO convert(UserEntity userEntity) {
        return LoginDTO.builder()
                .user(User.convert(userEntity))
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class User {

        private Long idx;
        private String email;
        private String id;
        private String pw;
        private List<String> roleList;

        public static User convert(UserEntity userEntity) {

            return User.builder()
                    .idx(userEntity.getIdx())
                    .email(userEntity.getEmail())
                    .id(userEntity.getId())
                    .pw(userEntity.getPw())
                    .roleList(userEntity.getUserRoleEntitiyList().stream()
                            .map(userRoleEntity -> userRoleEntity.getRole())
                            .toList())
                    .build();

        }
    }

}
