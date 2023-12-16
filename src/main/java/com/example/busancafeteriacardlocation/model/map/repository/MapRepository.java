package com.example.busancafeteriacardlocation.model.map.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;

public interface MapRepository extends JpaRepository<MapEntity, Long> {
    
    Optional<MapEntity> findByIdx(Long idx);

}
