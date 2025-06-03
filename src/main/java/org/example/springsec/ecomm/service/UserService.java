package org.example.springsec.ecomm.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.example.springsec.ecomm.dto.UserDto;
import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.repo.UserRepo;
import org.example.springsec.ecomm.validators.UserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void saveUser(UserDto userDto) {
        UserValidator
                .forUser(userDto, userRepo)
                .validateEmail()
                .validatePassword()
                .validateUsername();
        User user = User
                .builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .username(userDto.getUsername())
                .enabled(true)
                .cart(Cart.builder().createdDate(LocalDateTime.now()).build())
                .build();
        userRepo.save(user);
    }

    public User getUserById(@NotNull Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    public UserDto getById(@NotNull Long id) {
        User user = userRepo.findById(id).orElseThrow();
        return UserDto.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail()).password(user.getPassword()).build();
    }

    public User getUserByEmail(@NotNull String email) {
        return userRepo.findByEmail(email).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUserById(@NotNull Long id) {
        if (getUserById(id) != null) {
            userRepo.deleteById(id);
        } else {

        }
    }

    @Transactional
    public void updateUser(Long id, UserDto userDto) {
        User user = getUserById(id);
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
            System.out.println("Email ");
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
            System.out.println("Password ");
        }
        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername());
            System.out.println("Username ");
        }
        userRepo.save(user);
    }




}
