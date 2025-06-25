package org.example.springsec.ecomm.controller;

import lombok.AllArgsConstructor;
import org.example.springsec.ecomm.dto.UserDto;
import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    @Cacheable(value = "Users")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @Cacheable(value = "User",key = "#id")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/add")
    @CacheEvict(value = "Users",allEntries = true)
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    @CacheEvict(value = "Users",allEntries = true)
    public ResponseEntity<Void> deleteUserById(@RequestParam("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    @CacheEvict(value = {"Users","User"},allEntries = true)
    public ResponseEntity<Void> updateUser(@RequestParam("id") Long id,@RequestBody UserDto userDto){
        userService.updateUser(id,userDto);
        return ResponseEntity.ok().build();
    }

}
