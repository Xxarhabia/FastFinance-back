package com.msara.app.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_roles")
public class UsersRolesEntity {

    @EmbeddedId
    private UsersRolesId userRolesId;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class UsersRolesId implements Serializable {

        @Column(name = "id_user")
        private Integer userId;

        @Column(name = "id_role")
        private Integer roleId;
    }
}
