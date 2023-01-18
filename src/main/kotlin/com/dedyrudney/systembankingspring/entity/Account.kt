package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "compte_bancaire")
data class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var initialBalance: Float,
    var number: Int,
    var overDraftLimit: Int,
    var Owner: String,

    @ManyToOne
    var banks: Bank?=null,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    @JsonManagedReference
    val card: Card?=null,

//    @Column(name = "customer_id")
//    @JsonIgnore
//    var customerId: Long,

    @OneToOne(
        mappedBy = "accounts",
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    var customers: Customer?=null
    )