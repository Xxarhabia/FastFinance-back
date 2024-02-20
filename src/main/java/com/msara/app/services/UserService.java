package com.msara.app.services;

import com.msara.app.models.entities.RoleEntity;
import com.msara.app.models.entities.UserEntity;
import com.msara.app.repositories.RoleRepository;
import com.msara.app.repositories.UserRepository;
import com.msara.app.utils.enums.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void createClient(UserEntity userRequest) {

        RoleEntity clientRole = roleRepository.findByName(String.valueOf(RolesEnum.CLIENT));

        if (clientRole == null) {
            throw new RuntimeException("Role 'CLIENT' not found");
        }

        UserEntity newClient = UserEntity.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .mail(userRequest.getMail())
                .password(userRequest.getPassword())
                .roles(Set.of(clientRole))
                .build();

        userRepository.save(newClient);
    }

    public void assignRoleToUser(int idUser, int idRole) {
        UserEntity userFound = userRepository.findById(idUser).orElseThrow();
        RoleEntity roleFound = roleRepository.findById(idRole).orElseThrow();

        userFound.getRoles().add(roleFound);
        roleFound.getUsers().add(userFound);

        userRepository.save(userFound);
        roleRepository.save(roleFound);
    }


}
