package com.example.busancafeteriacardlocation.domain.map.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.busancafeteriacardlocation.domain.map.dto.APIRequestDTO;
import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;
import com.example.busancafeteriacardlocation.model.map.repository.MapRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InitService {

    private final MapRepository mapEntityRepository;

    @Value("${open-api.busan-cafeteria.api-key}")
    private String openApiKey;

    private static final int PAGE_SIZE = 10000;

    // 받아온 데이터를 데이터베이스에 저장하는 코드

    public void saveLocations() {
        List<MapEntity> mapEntities = getAndMapLocations();
        mapEntityRepository.saveAll(mapEntities);
    }

    // api에서 데이터를 받아오는 코드

    private List<MapEntity> getAndMapLocations() {
        List<MapEntity> mapEntities = new ArrayList<>();

        try {
            RestTemplate restTemplate = new RestTemplate();

            int currentPage = 1;
            boolean hasNextPage = true;

            while (hasNextPage) {
                String apiUrl = buildApiUrl(currentPage);
                APIRequestDTO pageResponse = restTemplate.getForObject(apiUrl, APIRequestDTO.class);

                hasNextPage = pageResponse != null && pageResponse.getCurrentCount() > 0;

                if (pageResponse != null && pageResponse.getData() != null) {
                    for (APIRequestDTO.APIResponseDTOData apiResponseData : pageResponse.getData()) {
                        mapEntities.add(mapDTOToEntity(apiResponseData));
                    }
                }

                currentPage++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapEntities;
    }

    // api 주소

    private String buildApiUrl(int currentPage) {
        return "http://api.odcloud.kr/api/15102055/v1/uddi:122cc22d-cde3-41d0-83c8-db83298b994f" +
                "?page=" + currentPage +
                "&perPage=" + PAGE_SIZE +
                "&returnType=JSON" +
                "&serviceKey=" + openApiKey;
    }

    // 받아온 데이터를 엔티티로 변환

    private MapEntity mapDTOToEntity(APIRequestDTO.APIResponseDTOData apiResponseData) {
        return MapEntity.builder()
                .franchiseDate(LocalDate.parse(apiResponseData.get가맹점기준일자()))
                .name(apiResponseData.get가맹점명칭())
                .longitude(apiResponseData.get경도())
                .dataDate(LocalDate.parse(apiResponseData.get데이터작성일자()))
                .streetAddress(apiResponseData.get도로명주소())
                .sector(apiResponseData.get업종())
                .latitude(apiResponseData.get위도())
                .numberAddress(apiResponseData.get지번주소())
                .build();
    }
}
