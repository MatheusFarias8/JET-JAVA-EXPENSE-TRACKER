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
@Table(name = "TB_INSTALLMENT_PLANS")
public class InstallmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    BigDecimal totalAmount;

    @Column(nullable = false)
    Integer totalInstallments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    LocalDateTime createdAt;

}
