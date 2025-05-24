package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int amount;
    private Date paymentDate;
    private String status;
    private String paymentMethod;

}
