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
    var transaction: MutableList<Transaction> = mutableListOf(),

//    @OneToOne(mappedBy = "card")
//    var account: Account
)