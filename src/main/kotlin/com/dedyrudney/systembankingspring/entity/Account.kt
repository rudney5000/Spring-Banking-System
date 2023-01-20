package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "compte_bancaire")
data class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_id")
    var id: Long,
    var initialBalance: Float,
    var number: Int,
    var overDraftLimit: Int,
    var Owner: String,

    @OneToOne(
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(
        name = "carte_id",
    )
    var card: Card,

    @Column(name = "customer_id")
    var customerId: Long,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    var customer: Customer?=null
)