package com.dedyrudney.systembankingspring.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "transfer")
data class Transfer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var amount: Int,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
        )