package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Transaction
import com.dedyrudney.systembankingspring.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController @Autowired private constructor(private val transactionService: TransactionService){

    @GetMapping("/transactions")
    fun getTransactionList(): List<Transaction> = transactionService.getAllTransaction()

    @GetMapping("/transactions/{id}")
    fun getTransaction(@PathVariable id: Long): Transaction = transactionService.getTransaction(id)

    @PostMapping("/transactions")
    fun createTransaction(@RequestBody transaction: Transaction): Transaction = transactionService.saveTransaction(transaction)

    @PutMapping("/transactions/{id}")
    fun updateTransaction(@PathVariable id: Long, @RequestBody transaction: Transaction): Transaction = transactionService.updateTransaction(id, transaction)

    @DeleteMapping("/transactions/id")
    fun deleteTransaction(@PathVariable id: Long): String = transactionService.deleteTransaction(id)
}