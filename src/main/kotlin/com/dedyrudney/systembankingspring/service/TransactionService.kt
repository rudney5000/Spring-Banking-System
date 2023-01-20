package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Transaction
import com.dedyrudney.systembankingspring.exception.TransactionNotFoundException
import com.dedyrudney.systembankingspring.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService @Autowired private constructor(private val transactionRepository: TransactionRepository){

    fun getAllTransaction(): List<Transaction> = transactionRepository.findAll()

    fun getTransaction(id: Long): Transaction = transactionRepository
        .findById(id)
        .orElseThrow {
            TransactionNotFoundException( "Transaction with id = $id was not found")
        }

    fun saveTransaction(transaction: Transaction): Transaction = transactionRepository.save(transaction)

    fun updateTransaction(id: Long, transactionInput: Transaction): Transaction {
        return if (transactionRepository.existsById(id)){
            transactionRepository.save(
                Transaction(
                    id = transactionInput.id,
                    currentBalance = transactionInput.currentBalance,
                    number = transactionInput.number,
                    withDrawl = transactionInput.withDrawl,
                    deposit = transactionInput.deposit,
                    transfer = transactionInput.transfer,
                    card = transactionInput.card,
//                    session = transactionInput.session,
                    cardId = transactionInput.cardId
                )
            )
        }else throw TransactionNotFoundException("No matching transaction was found")
    }

    fun deleteTransaction(id: Long): String {
        val transactionFound = getTransaction(id)

        transactionRepository.delete(transactionFound)
        return "Transaction Canceled!"
    }
}