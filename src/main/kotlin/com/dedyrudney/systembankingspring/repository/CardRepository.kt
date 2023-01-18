package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CardRepository:JpaRepository<Card, Long> {

    fun findByNumber(number: String): Optional<Card>
}