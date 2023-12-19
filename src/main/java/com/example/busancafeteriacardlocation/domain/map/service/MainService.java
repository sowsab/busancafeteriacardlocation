package com.example.busancafeteriacardlocation.domain.map.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.busancafeteriacardlocation.domain.map.dto.ResMapDataDTO;
import com.example.busancafeteriacardlocation.domain.map.dto.ResSelectedMapDataDTO;
import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;
import com.example.busancafeteriacardlocation.model.map.repository.MapRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MapRepository mapRepository;

    // 지도 데이터를 가져오는 코드

    public ResMapDataDTO getMapData() {

        List<MapEntity> mapEntityList = mapRepository.findAll();

        return ResMapDataDTO.convert(mapEntityList);

    }

    // 검색 기능을 사용하여 데이터를 가져오는 코드

    public ResSelectedMapDataDTO searchGetMapData(String keyword) {

        List<MapEntity> mapEntitylist = mapRepository.findByKeywordContaining(keyword);

        return ResSelectedMapDataDTO.convert(mapEntitylist);

    }

}
