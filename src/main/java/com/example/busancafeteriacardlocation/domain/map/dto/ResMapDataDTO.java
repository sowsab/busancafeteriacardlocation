package com.example.busancafeteriacardlocation.domain.map.dto;

import java.time.LocalDate;

import java.util.List;

import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ResMapDataDTO {

    private List<ReqMapDataDTO> reqMapDataDTOList;

    public static ResMapDataDTO convert(List<MapEntity> mapEntitityList) {
        return ResMapDataDTO.builder()
                .reqMapDataDTOList(mapEntitityList.stream()
                        .map(mapEntity -> ReqMapDataDTO.convert(mapEntity))
                        .toList())
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class ReqMapDataDTO {

        private Long idx;
        private LocalDate franchiseDate;
        private String name;
        private String longitude;
        private LocalDate dataDate;
        private String streetAddress;
        private String sector;
        private String latitude;
        private String numberAddress;

        public static ReqMapDataDTO convert(MapEntity mapEntity) {
            return ReqMapDataDTO.builder()
                    .idx(mapEntity.getIdx())
                    .franchiseDate(mapEntity.getFranchiseDate())
                    .name(mapEntity.getName())
                    .longitude(mapEntity.getLongitude())
                    .dataDate(mapEntity.getDataDate())
                    .streetAddress(mapEntity.getStreetAddress())
                    .sector(mapEntity.getSector())
                    .latitude(mapEntity.getLatitude())
                    .numberAddress(mapEntity.getNumberAddress())
                    .build();
        }

    }

}
