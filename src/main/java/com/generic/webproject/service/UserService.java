package com.generic.webproject.service;

import com.generic.webproject.data.UserDTO;
import com.generic.webproject.entity.User;
import com.generic.webproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class UserService extends GenericService<User, UserDTO, UserRepository>{

    @Inject
    private UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Class<UserDTO> getDtoClass() {
        return UserDTO.class;
    }
}
