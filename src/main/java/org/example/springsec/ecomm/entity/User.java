package org.example.springsec.ecomm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "_users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String username;
    @Email
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")
    private String password;
    private Boolean enabled;

    @OneToMany(mappedBy = "user",cascade = {PERSIST,MERGE})
    private List<Order> orders;

    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @OneToMany(mappedBy = "user",cascade = {PERSIST,MERGE,REMOVE})
    private List<Address> addresses;

    @OneToMany(mappedBy = "user",cascade = {PERSIST,MERGE,REMOVE})
    private List<Review> reviews;
}
