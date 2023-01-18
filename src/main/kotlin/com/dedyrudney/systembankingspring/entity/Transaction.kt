package com.dedyrudney.systembankingspring.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "transaction")
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var amount: Float,
    var currentBalance: Float,
    var date: Date,
    var done: Boolean,
    var number: String,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,

    @ManyToOne
    var currency: Currency?=null
)