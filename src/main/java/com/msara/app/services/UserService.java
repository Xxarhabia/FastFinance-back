package com.msara.app.services;

import com.msara.app.models.entities.RoleEntity;
import com.msara.app.models.entities.UserEntity;
import com.msara.app.models.entities.UsersRolesEntity;
import com.msara.app.repositories.RoleRepository;
import com.msara.app.repositories.UserRepository;
import com.msara.app.repositories.UsersRolesRepository;
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

    @Autowired
    private UsersRolesRepository usersRolesRepository;

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

        if (usersRolesRepository.existsByUserRolesIdUserIdAndUserRolesIdRoleId(idUser, idRole)) {
            throw new RuntimeException("User already has this role");
        }

        UsersRolesEntity.UsersRolesId usersRolesId = new UsersRolesEntity.UsersRolesId(idUser, idRole);
        UsersRolesEntity usersRoles = new UsersRolesEntity(usersRolesId);

        usersRolesRepository.save(usersRoles);
    }


}
