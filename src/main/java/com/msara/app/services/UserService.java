package com.msara.app.services;

import com.msara.app.models.entities.RoleEntity;
import com.msara.app.models.entities.UserEntity;
import com.msara.app.repositories.RoleRepository;
import com.msara.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void createOwner(UserEntity userRequest) {

        RoleEntity ownerRole = roleRepository.findByRoleName("owner");

        if (ownerRole == null) {
            throw new RuntimeException("Role 'owner' not found");
        }

        UserEntity newOwner = new UserEntity();
        fillData(userRequest);
        newOwner.setRole(ownerRole);

        userRepository.save(newOwner);
    }

    public void createEmployee(UserEntity userRequest) {

        RoleEntity employeeRole = roleRepository.findByRoleName("employee");

        if (employeeRole == null) {
            throw new RuntimeException("Role 'employee' not found");
        }

        UserEntity newEmployee = new UserEntity();
        fillData(userRequest);
        newEmployee.setRole(employeeRole);

        userRepository.save(newEmployee);
    }

    public void fillData(UserEntity userRequest) {
        UserEntity newUser = new UserEntity();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setMail(userRequest.getMail());
        newUser.setPassword(userRequest.getPassword());
    }
}
