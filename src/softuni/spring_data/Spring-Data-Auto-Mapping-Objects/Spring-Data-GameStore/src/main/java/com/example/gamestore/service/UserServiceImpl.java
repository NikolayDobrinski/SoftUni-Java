package com.example.gamestore.service;

import com.example.gamestore.model.dto.UserLoginDto;
import com.example.gamestore.model.dto.UserRegisterDto;
import com.example.gamestore.model.entity.User;
import com.example.gamestore.repository.UserRepository;
import com.example.gamestore.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
        }
        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.getViolations(userRegisterDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        User user = modelMapper.map(userRegisterDto, User.class);

        userRepository.save(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        User user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()).orElse(null);

        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;
    }

    @Override
    public void logout() {
        if (loggedInUser == null) {
            System.out.println("Cannot logout. No user was logged in.");
        }
        else {
            loggedInUser = null;
        }
    }
}
