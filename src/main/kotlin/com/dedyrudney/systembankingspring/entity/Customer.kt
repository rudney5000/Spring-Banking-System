package com.dedyrudney.systembankingspring.entity

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

    @OneToOne(
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @JsonManagedReference
    var accounts: Account? = null,

    @ManyToOne
    var bank: Bank?=null,

    @OneToOne(
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @JsonManagedReference
    var card: Card?=null
    )