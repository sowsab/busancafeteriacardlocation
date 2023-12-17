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

    public ResMapDataDTO getMapData() {

        List<MapEntity> mapEntityList = mapRepository.findAll();

        return ResMapDataDTO.convert(mapEntityList);

    }

    public ResSelectedMapDataDTO searchGetMapData(String keyword) {

        List<MapEntity> mapEntitylist = mapRepository.findByKeywordContaining(keyword);

        return ResSelectedMapDataDTO.convert(mapEntitylist);

    }

}
