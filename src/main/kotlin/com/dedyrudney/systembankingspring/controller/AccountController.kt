package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Account
import com.dedyrudney.systembankingspring.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController @Autowired private constructor(private val accountService: AccountService){

    @GetMapping("/accounts")
    fun getAccountList(): List<Account> = accountService.getAccounts()

    @GetMapping("/accounts/{id}")
    fun getAccount(@PathVariable id:Long): Account = accountService.getOne(id)

    @PostMapping("/accounts")
    fun createAccount(@RequestBody account: Account): Account = accountService.saveAccount(account)

    @PutMapping("/accounts/{id}")
    fun updateAccount(@RequestBody account: Account, @PathVariable id: Long): Account = accountService.updateAccount(id, account)

    @DeleteMapping("/accounts/{id}")
    fun deleteAccount(@PathVariable id: Long): String = accountService.deleteAccount(id)
}