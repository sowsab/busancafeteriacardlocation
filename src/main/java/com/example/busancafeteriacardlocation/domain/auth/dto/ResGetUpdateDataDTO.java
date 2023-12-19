package com.example.busancafeteriacardlocation.domain.auth.dto;

import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ResGetUpdateDataDTO {
    
    private ReqGetUpdateDataDTO reqGetUpdateDataDTO;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class ReqGetUpdateDataDTO {
    
        private Long idx;

        private String email;

        private String id;

        
        public static ReqGetUpdateDataDTO convert(UserEntity userEntity) {
            return ReqGetUpdateDataDTO.builder()
            .idx(userEntity.getIdx())
            .email(userEntity.getEmail())
            .id(userEntity.getId())
            .build();
        }
    }

}
