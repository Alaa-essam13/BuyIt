package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("""
                    select u from User u where u.email=:email
            """)
    Optional<User> findByEmail(String email);

    @Query("""
                    select u from User u where u.username=:username
            """)
    Optional<User> findByUsername(String username);


}
