package com.example.busancafeteriacardlocation.model.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busancafeteriacardlocation.model.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdx(Long id);

    Optional<UserEntity> findById(String id);

}
