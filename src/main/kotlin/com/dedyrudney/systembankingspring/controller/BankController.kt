package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Bank
import com.dedyrudney.systembankingspring.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BankController @Autowired private constructor(private val bankService: BankService){
    @GetMapping("/banks")
    fun getBankList(): List<Bank> = bankService.getBanks()

    @GetMapping("/banks/{id}")
    fun getBank(@PathVariable id: Long): Bank = bankService.getOne(id)

    @PostMapping("/banks")
    fun createBank(@RequestBody bank: Bank): Bank = bankService.saveBank(bank)

    @PutMapping("/banks/{id}")
    fun updateBank(@RequestBody bank: Bank, @PathVariable id: Long): Bank = bankService.updateBank(id, bank)

    @DeleteMapping("/banks/{id}")
    fun deleteBank(@PathVariable id: Long): String = bankService.deleteBank(id)

}