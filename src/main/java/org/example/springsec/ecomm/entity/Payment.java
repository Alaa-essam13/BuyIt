package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.springsec.ecomm.dto.PaymentMethod;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "_payment")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Payment {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private int amount;
    private LocalDateTime paymentDate;
    private String status;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
