package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "session")
class Session (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var lastMessage: String,
    var number: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "transaction_id")
    var transaction: Transaction,

    @Column(name = "atm_id")
    var atmId: Long,

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var atm: ATM? = null,

    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)