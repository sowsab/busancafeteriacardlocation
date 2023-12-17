package com.example.busancafeteriacardlocation.domain.map.dto;

import java.util.List;

import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ResSelectedMapDataDTO {

    private List<ReqSelectedMapDataDTO> reqSelectedMapDataDTOlist;

    public static ResSelectedMapDataDTO convert(List<MapEntity> mapEntityList) {
        return ResSelectedMapDataDTO.builder()
                .reqSelectedMapDataDTOlist(mapEntityList.stream()
                        .map(mapEntity -> ReqSelectedMapDataDTO.convert(mapEntity))
                        .toList())
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class ReqSelectedMapDataDTO {

        private Long idx;
        private LocalDate franchiseDate;
        private String name;
        private String longitude;
        private LocalDate dataDate;
        private String streetAddress;
        private String sector;
        private String latitude;
        private String numberAddress;

        public static ReqSelectedMapDataDTO convert(MapEntity mapEntity) {
            return ReqSelectedMapDataDTO.builder()
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
