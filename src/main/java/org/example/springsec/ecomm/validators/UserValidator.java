package org.example.springsec.ecomm.validators;

import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.repo.UserRepo;

public class UserValidator<T extends User> {
    private final T user;
    private final UserRepo userRepo;

    private UserValidator(T user, UserRepo userRepo) {
        this.user = user;
        this.userRepo = userRepo;
    }

    public static <T extends User> UserValidator<T> forUser(T user, UserRepo userRepo) {
        return new UserValidator<>(user, userRepo);
    }

    public UserValidator<T> validateEmail() {
        if (user.getEmail() == null||user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        return this;
    }

    public UserValidator<T> validatePassword() {
        if (user.getPassword() == null||user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return this;
    }

    public UserValidator<T> validateUsername() {
        if (user.getUsername() == null||user.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        return this;
    }

    public UserValidator<T> setDefaults() {
        if (user.getEnabled() == null) {
            user.setEnabled(true);
        }
        return this;
    }

    public T get() {
        return user;
    }
}
