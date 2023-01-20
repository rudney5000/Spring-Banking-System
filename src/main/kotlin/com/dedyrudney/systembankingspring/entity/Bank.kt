package com.dedyrudney.systembankingspring.entity

import javax.persistence.*

@Entity
@Table(name = "bank")
data class Bank (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var code: String,
    var name: String,

//    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "bank")
//    var accounts: MutableList<Account> = mutableListOf(),

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "bank"
    )
    var atm: MutableList<ATM> = mutableListOf(),

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "bank"
    )
    var customer: MutableList<Customer> = mutableListOf()
)