package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.ATM
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ATMRepository: JpaRepository<ATM, Long> {

    fun findByAddress(address: String): Optional<ATM>
}