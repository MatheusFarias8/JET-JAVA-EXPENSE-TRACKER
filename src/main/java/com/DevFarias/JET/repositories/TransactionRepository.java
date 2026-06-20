package com.DevFarias.JET.repositories;

import com.DevFarias.JET.domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
