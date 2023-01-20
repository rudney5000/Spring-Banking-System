package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "carte")
data class Card (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(
//        name = "ca_id",
//    )
    var id: Long,
    var expirationdate: String,
    var holdername: String,
    var number: String,
    var cvv: String,

    @Enumerated(EnumType.STRING)
    var money: Money?=null,

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "card"
    )
    var transaction: MutableList<Transaction> = mutableListOf()

//    @OneToOne(
//        mappedBy = "card",
//////        cascade = [CascadeType.ALL],
//////        fetch = FetchType.EAGER
//    )
//////    @JsonManagedReference
//    var account: Account,

//    @OneToMany(
//        mappedBy = "cards",
//        cascade = [CascadeType.ALL]
//    )
//    var sessions: MutableList<Session> = mutableListOf(),

//    @OneToOne(
//        mappedBy = "",
//        cascade = [CascadeType.ALL],
//        fetch = FetchType.EAGER
//    )
//    @JoinColumn(name = "customer_id")
//    @JsonManagedReference
//    var customerCard: Customer?=null
)