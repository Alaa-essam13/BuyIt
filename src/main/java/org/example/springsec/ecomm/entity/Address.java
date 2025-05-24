package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private String city;
    private String country;
    private String zipCode;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
