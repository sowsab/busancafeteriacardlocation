package com.example.busancafeteriacardlocation.model.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busancafeteriacardlocation.model.user.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    
    List<UserRoleEntity> findByUserEntity_idx(Long idx);

}
