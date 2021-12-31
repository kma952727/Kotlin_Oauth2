package com.example.demo.account.model

import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(val nameArg: String?, val refreshTokenArg: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var refreshToken: String? = null

    init {
        this.name = nameArg
        this.refreshToken = refreshTokenArg
    }
}