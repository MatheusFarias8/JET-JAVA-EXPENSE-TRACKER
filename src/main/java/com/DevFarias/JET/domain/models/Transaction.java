package com.DevFarias.JET.domain.models;

import com.DevFarias.JET.domain.enums.TransactionStatus;
import com.DevFarias.JET.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private int id;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransactionStatus status;

    @Column(nullable = false)
    LocalDate transactionDate;

    @Column(nullable = false)
    LocalDate dueDate;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "installment_plan_id")
    InstallmentPlan installmentPlan;

    Boolean recurring;

}
