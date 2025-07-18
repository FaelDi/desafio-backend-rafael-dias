package com.wordpress.faeldi.desafio.backend.repository;

import com.wordpress.faeldi.desafio.backend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transaction, Long> {
}
