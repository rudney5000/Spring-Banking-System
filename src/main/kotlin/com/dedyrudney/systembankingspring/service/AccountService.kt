package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Account
import com.dedyrudney.systembankingspring.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService @Autowired private constructor(private val accountRepository: AccountRepository){
    fun getAccounts(): List<Account> = accountRepository.findAll()

    fun getOne(id: Long): Account = accountRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("Account with this $id was not Found!")
        }

    fun saveAccount(account: Account): Account = accountRepository.save(account)

    fun updateAccount(id: Long, accountInput: Account): Account {
        val accountFound = getOne(id)

        accountFound.initialBalance = accountInput.initialBalance
        accountFound.Owner = accountInput.Owner
        accountFound.number = accountInput.number
        accountFound.overDraftLimit = accountInput.overDraftLimit
//        accountFound.bank = accountInput.bank
        accountFound.card = accountInput.card
        accountFound.customer = accountInput.customer

        return accountRepository.save(accountFound)
    }

    fun deleteAccount(id: Long): String{
        val accountFound = getOne(id)

        accountRepository.delete(accountFound)
        return "Account deleted!"
    }

}