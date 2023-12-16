package com.example.busancafeteriacardlocation.model.map.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`MAP`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "franchiseDate", nullable = false)
    private LocalDate franchiseDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "dataDate")
    private LocalDate dataDate;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "sector")
    private String sector;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "numberAddress")
    private String numberAddress;
}
