package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.ATM
import com.dedyrudney.systembankingspring.service.ATMService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ATMController @Autowired private constructor(private val atmService: ATMService){

    @GetMapping("/atms")
    fun getATMList(): List<ATM> = atmService.getAllATM()

    @GetMapping("/atms/{id}")
    fun getATM(@PathVariable id: Long): ATM = atmService.getATM(id)

    @PostMapping("/atms")
    fun createATM(@RequestBody atm: ATM): ATM = atmService.saveATM(atm)

    @PutMapping("/atms/{id}")
    fun updateATM(@PathVariable id: Long, @RequestBody atm: ATM): ATM = atmService.updateATM(id, atm)

    @DeleteMapping("/atms/{id}")
    fun deleteATM(@PathVariable id: Long): String = atmService.deleteATM(id)
}