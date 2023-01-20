package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "client")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var username: String,
    var fullname: String,
    var city: String,
    var country: String,
    var address: String,
    var email: String,
    var password: String,
    var dob: String,

//    @Column(name = "customer_id")
//    var accountId: Long,

    @OneToMany(
        mappedBy = "customer",
        cascade = [CascadeType.ALL],
    )
    var account: MutableList<Account> = mutableListOf(),

    @Column(name = "bank_id")
    var bankId: Long,

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var bank: Bank?=null,

//    @OneToOne(
//        cascade = [CascadeType.ALL],
//        fetch = FetchType.EAGER
//    )
//    @JsonManagedReference
//    var card: Card?=null
    )