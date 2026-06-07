package com.DevFarias.JET.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_CREDIT_CARDS")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    BigDecimal creditLimit;

    @Column(nullable = false)
    Integer closingDay;

    @Column(nullable = false)
    Integer dueDay;

    @Column(nullable = false)
    Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    LocalDateTime createdAt;

}
