package org.example.springsec.ecomm.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.springsec.ecomm.dto.PaymentMethod;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "_order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

}
