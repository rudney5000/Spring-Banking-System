package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Currency
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CurrencyRepository:JpaRepository<Currency, Long> {
    fun findBySymbol(symbol: String): Optional<Currency>
}