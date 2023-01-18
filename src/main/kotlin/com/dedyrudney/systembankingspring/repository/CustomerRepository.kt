package com.dedyrudney.systembankingspring.repository

import com.dedyrudney.systembankingspring.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {

    fun findByUsername(username: String): Optional<Customer>
}