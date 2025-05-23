package org.example.springsec.ecomm.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.repo.UserRepo;
import org.example.springsec.ecomm.validators.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void saveUser(User user){
        User user1 = UserValidator
                .forUser(user,userRepo)
                .validateEmail()
                .validatePassword()
                .validateUsername()
                .setDefaults()
                .get();
        userRepo.save(user1);
    }

    public User getUserById(@NotNull Long id){
        return userRepo.findById(id).orElseThrow();
    }

    public User getUserByEmail(@NotNull String email){
        return userRepo.findByEmail(email).orElseThrow();
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }


}
