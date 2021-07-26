package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dtos.UserSeedDto;
import com.example.xmlexercise.model.dtos.UserViewRootDto;
import com.example.xmlexercise.model.entity.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProducts();
}
