package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.ATM
import com.dedyrudney.systembankingspring.repository.ATMRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ATMService @Autowired private constructor(private val atmRepository: ATMRepository){

    fun getAllATM(): List<ATM> = atmRepository.findAll()

    fun getATM(id: Long): ATM = atmRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("The ATM with this $id was not Found!")
        }

    fun saveATM(atm: ATM): ATM = atmRepository.save(atm)

    fun updateATM(id: Long, atmInput: ATM): ATM {
        val atmToUpdate = getATM(id)
        atmToUpdate.money = atmInput.money
        atmToUpdate.bank = atmInput.bank
        atmToUpdate.session = atmInput.session
//        atmToUpdate.country = atmInput.country
        atmToUpdate.city = atmInput.city
        atmToUpdate.address = atmInput.address

        return atmRepository.save(atmToUpdate)
    }

    fun deleteATM(id: Long): String {
        val atmDelete = getATM(id)

        atmRepository.delete(atmDelete)
        return "ATM Deleted!"
    }
}