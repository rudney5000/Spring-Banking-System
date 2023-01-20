package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "transaction")
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var currentBalance: Float,
//    var done: Boolean,
    var number: String,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "retrait_id",
    )
    var withDrawl: WithDrawl,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "transfer_id",
    )
    var transfer: Transfer,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "depot_id",
    )
    var deposit: Deposit,

    @Column(name = "card_id")
    var cardId: Long,

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var card: Card? = null,

    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,

//    @ManyToOne
//    var currency: Currency?=null
)