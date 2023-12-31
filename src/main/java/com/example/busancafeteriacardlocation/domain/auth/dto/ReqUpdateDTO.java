package com.example.busancafeteriacardlocation.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqUpdateDTO {
    
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class User {

        private String email;

        private String id;

        private String pw;

        private String checkpw;

    }

}
