package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TransactionRepository:JpaRepository<Transaction, Long> {
    fun findByNumber(number: String): Optional<Transaction>
}