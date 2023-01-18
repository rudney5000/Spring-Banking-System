package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AccountRepository: JpaRepository<Account, Long> {

    fun findByNumber(number: Int): Optional<Account>
}