package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SessionRepository:JpaRepository<Session, Long> {
    fun findByNumber(number: String): Optional<Session>
}