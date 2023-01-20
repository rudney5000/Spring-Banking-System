package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "guichet_automatique")
data class ATM (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
//    var managedBy: String,
//    var country: String,
    var city: String,
    var address: String,

    @Enumerated(EnumType.STRING)
    var money: Money? = null,

    @OneToMany(
        mappedBy = "atm",
        cascade = [CascadeType.ALL]
    )
    var session: MutableList<Session> = mutableListOf(),

    @Column(name = "bank_id")
    var bankId: Long,

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var bank: Bank? =null
)