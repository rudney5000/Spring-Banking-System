package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Card
import com.dedyrudney.systembankingspring.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired import org.springframework.stereotype.Service

@Service
class CardService @Autowired private constructor(private val cardRepository: CardRepository){

    fun getAllCard(): List<Card> = cardRepository.findAll()

    fun getCard(id: Long): Card = cardRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("Card with this $id was not Found!")
        }

    fun saveCard(card: Card): Card = cardRepository.save(card)

    fun updateCard(id: Long, cardInput: Card): Card {
        return if (cardRepository.existsById(id)){
            cardRepository.save(
                Card(
                    id = cardInput.id,
                    expirationdate = cardInput.expirationdate,
                    holdername = cardInput.holdername,
                    number = cardInput.number,
                    cvv = cardInput.cvv,
                    account = cardInput.account,
                    sessions = cardInput.sessions,
                    customerCard = cardInput.customerCard
                )
            )
        }else throw  IllegalArgumentException("No matching card was found")
    }

    fun deleteCard(id: Long): String{
        val cardFound = getCard(id)

        cardRepository.delete(cardFound)
        return "Card deleted!"
    }

}