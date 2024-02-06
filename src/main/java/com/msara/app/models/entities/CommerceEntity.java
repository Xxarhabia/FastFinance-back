package com.msara.app.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commerce")
public class CommerceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commerce_id")
    private Integer id;

    @Column(name = "commerce_name")
    private String name;

    @Column(name = "commerce_address")
    private String address;

    @Column(name = "commerce_phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
