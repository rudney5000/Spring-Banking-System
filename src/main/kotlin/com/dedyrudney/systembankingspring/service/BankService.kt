package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Bank
import com.dedyrudney.systembankingspring.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BankService @Autowired private constructor(private var bankRepository: BankRepository){

    fun getBanks(): List<Bank> = bankRepository.findAll()

    fun getOne(id: Long): Bank = bankRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("Bank with this $id was not found")
        }

    fun saveBank(bank: Bank): Bank = bankRepository.save(bank)

    fun updateBank(id: Long, bankInput: Bank): Bank {
        val bankFound = getOne(id)

        bankFound.code = bankInput.code
        bankFound.name = bankInput.name
        bankFound.atms = bankInput.atms
//        bankFound.accounts = bankInput.accounts
        bankFound.customer = bankInput.customer

        return bankRepository.save(bankFound)
    }

    fun deleteBank(id: Long): String{
        val bankFound = getOne(id)

        bankRepository.delete(bankFound)
        return "Bank deleted"
    }


}