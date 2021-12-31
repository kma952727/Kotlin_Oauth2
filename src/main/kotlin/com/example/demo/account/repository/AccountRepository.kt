package com.example.demo.account.repository

import com.example.demo.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository:JpaRepository<Account, Long> {
}