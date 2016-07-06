package com.generic.webproject.controller;

import com.generic.webproject.data.UserDTO;
import com.generic.webproject.entity.User;
import com.generic.webproject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/user", headers = {"Accept=application/json"})
public class UserController extends GenericCrudController<User, UserDTO, UserService>{

    @Inject
    private UserService userService;

    @Override
    public UserService getService() {
        return userService;
    }
}
