package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Bank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BankRepository: JpaRepository<Bank, Long> {

    fun findByName(name: String): Optional<Bank>
}