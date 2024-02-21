package com.msara.app.repositories;

import com.msara.app.models.entities.UsersRolesEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRolesEntity, UsersRolesEntity.UsersRolesId> {
    boolean existsByUserRolesIdUserIdAndUserRolesIdRoleId(Integer idUser, Integer idRole);
}
