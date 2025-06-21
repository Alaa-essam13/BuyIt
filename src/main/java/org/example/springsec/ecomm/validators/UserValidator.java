package org.example.springsec.ecomm.validators;

import org.example.springsec.ecomm.dto.UserDto;
import org.example.springsec.ecomm.error.DuplicatedRecordException;
import org.example.springsec.ecomm.error.InvalidValueException;
import org.example.springsec.ecomm.repo.UserRepo;

public class UserValidator<T extends UserDto> {
    private final T user;
    private final UserRepo userRepo;

    private UserValidator(T user, UserRepo userRepo) {
        this.user = user;
        this.userRepo = userRepo;
    }

    public static <T extends UserDto> UserValidator<T> forUser(T user, UserRepo userRepo) {
        return new UserValidator<>(user, userRepo);
    }

    public UserValidator<T> validateEmail() {
        if (user.getEmail() == null||user.getEmail().isBlank()) {
            throw new InvalidValueException("Email cannot be null");
        }
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicatedRecordException("Email already exists");
        }
        return this;
    }

    public UserValidator<T> validatePassword() {
        if (user.getPassword() == null||user.getPassword().isBlank()) {
            throw new InvalidValueException("Password cannot be null");
        }
        return this;
    }

    public void validateUsername() {
        if (user.getUsername() == null||user.getUsername().isBlank()) {
            throw new InvalidValueException("Username cannot be null");
        }
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicatedRecordException("Username already exists");
        }
    }

    public T get() {
        return user;
    }
}
