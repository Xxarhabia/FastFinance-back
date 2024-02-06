package com.msara.app.repositories;

import com.msara.app.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByRoleName(String name);
}
