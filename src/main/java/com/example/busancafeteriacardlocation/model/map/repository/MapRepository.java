package com.example.busancafeteriacardlocation.model.map.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.busancafeteriacardlocation.model.map.entity.MapEntity;
import java.util.List;

public interface MapRepository extends JpaRepository<MapEntity, Long> {

    Optional<MapEntity> findByIdx(Long idx);

    @Query("SELECT m FROM MapEntity m " +
           "WHERE m.name LIKE %:keyword% OR m.streetAddress LIKE %:keyword% OR m.numberAddress LIKE %:keyword%")
    List<MapEntity> findByKeywordContaining(@Param("keyword") String keyword);
}
