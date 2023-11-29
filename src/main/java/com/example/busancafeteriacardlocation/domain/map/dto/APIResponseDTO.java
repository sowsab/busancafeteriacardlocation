package com.example.busancafeteriacardlocation.domain.map.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class APIResponseDTO {
    private int currentCount;
    private List<APIResponseDTOData> data;
    private int matchCount;
    private int page;
    private int perPage;
    private int totalCount;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class APIResponseDTOData {

        private String 가맹점기준일자;
        private String 가맹점명칭;
        private String 경도;
        private String 데이터작성일자;
        private String 도로명주소;
        private String 업종;
        private String 위도;
        private String 지번주소;

    }

}
