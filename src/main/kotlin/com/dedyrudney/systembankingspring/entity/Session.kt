package com.dedyrudney.systembankingspring.entity

import javax.persistence.*

@Entity
@Table(name = "session")
class Session (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var lastMessage: String,
    var number: String,

    @ManyToOne
    var cards: Card?=null,

    @ManyToOne
    var atm: ATM? = null
        )