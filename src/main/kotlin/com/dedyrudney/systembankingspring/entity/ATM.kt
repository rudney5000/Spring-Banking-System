package com.dedyrudney.systembankingspring.entity

import javax.persistence.*

@Entity
@Table(name = "guichet_automatique")
data class ATM (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var managedBy: String,
    var localisation: String,

    @Enumerated(EnumType.STRING)
    var money: Money? = null,

    @OneToMany(
        mappedBy = "atm",
        cascade = [CascadeType.ALL]
    )
    var session: MutableList<Session> = mutableListOf(),

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var bank: Bank? =null
)