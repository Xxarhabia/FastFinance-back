package com.msara.app.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> userEntities;
}
