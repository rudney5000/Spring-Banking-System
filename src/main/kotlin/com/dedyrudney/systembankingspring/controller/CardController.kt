package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Card
import com.dedyrudney.systembankingspring.service.AccountService
import com.dedyrudney.systembankingspring.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
//@RequestMapping("/bank")
class CardController @Autowired private constructor(
    private val cardService: CardService)
{

    @GetMapping("/cards")
    fun getCardList(): List<Card> = cardService.getAllCard()

    @GetMapping("/cards/{id}")
    fun getCard(@PathVariable id: Long): Card = cardService.getCard(id)

    @PostMapping("/cards")
    fun createCard(@RequestBody card: Card): Card = cardService.saveCard(card)

    @PutMapping("/cards/{id}")
    fun updateCard(@PathVariable id: Long, @RequestBody card: Card): Card = cardService.updateCard(id, card)

    @DeleteMapping("/cards/{id}")
    fun deleteCard(@PathVariable id: Long): String = cardService.deleteCard(id)
}