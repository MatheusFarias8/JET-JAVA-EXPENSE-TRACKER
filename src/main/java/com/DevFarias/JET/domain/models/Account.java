package com.DevFarias.JET.domain.models;

import com.DevFarias.JET.domain.enums.AccountType;
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
@Table(name = "TB_ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @Column(nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AccountType accountType;

    @Column(nullable = false)
    BigDecimal initialBalance;

    @Column(nullable = false)
    Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;


}
