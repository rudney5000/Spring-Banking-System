package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Bank
import com.dedyrudney.systembankingspring.exception.BankNotFoundException
import com.dedyrudney.systembankingspring.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BankService @Autowired private constructor(private var bankRepository: BankRepository){

    fun getAllBank(): List<Bank> = bankRepository.findAll()

    fun getBank(id: Long): Bank = bankRepository
        .findById(id)
        .orElseThrow {
            BankNotFoundException("Bank with this $id was not found")
        }

    fun saveBank(bank: Bank): Bank = bankRepository.save(bank)

    fun updateBank(id: Long, bankInput: Bank): Bank {
        val bankFound = getBank(id)

        bankFound.code = bankInput.code
        bankFound.name = bankInput.name
        bankFound.atm = bankInput.atm
//        bankFound.accounts = bankInput.accounts
        bankFound.customer = bankInput.customer

        return bankRepository.save(bankFound)
    }

    fun deleteBank(id: Long): String{
        val bankFound = getBank(id)

        bankRepository.delete(bankFound)
        return "Bank deleted"
    }
}