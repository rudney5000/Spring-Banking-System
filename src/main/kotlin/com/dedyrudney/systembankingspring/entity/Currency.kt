package com.dedyrudney.systembankingspring.entity

import javax.persistence.*

@Entity
data class Currency (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var country: String,
    var symbol: String,

    @Enumerated(EnumType.STRING)
    var money: Money?=null,

//    @OneToMany(
//        mappedBy = "currency",
//        cascade = [CascadeType.ALL]
//    )
//    var transaction: MutableList<Transaction> = mutableListOf()
)