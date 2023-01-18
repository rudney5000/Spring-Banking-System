package com.dedyrudney.systembankingspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "carte")
data class Card (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var expirationdate: Date,
    var holdername: String,
    var number: String,
    var password: String,

    @Column(name = "account_id")
    @JsonIgnore
    var accountId: Long,

    @OneToOne(
        mappedBy = "card",
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @JsonManagedReference
    var accountsCard: Account?=null,

    @OneToMany(
        mappedBy = "cards",
        cascade = [CascadeType.ALL]
    )
    var sessions: MutableList<Session> = mutableListOf(),

    @OneToOne(
        mappedBy = "",
        cascade = [CascadeType.ALL],
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    var customerCard: Customer?=null
)