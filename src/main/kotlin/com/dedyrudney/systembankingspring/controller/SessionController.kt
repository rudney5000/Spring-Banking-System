package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Session
import com.dedyrudney.systembankingspring.service.SessionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionController @Autowired private constructor(private val sessionService: SessionService){

    @GetMapping("/sessions")
    fun getSessionList(): List<Session> = sessionService.getAllSession()

    @GetMapping("/sessions/{id}")
    fun getSession(@PathVariable id: Long): Session = sessionService.getSession(id)

    @PostMapping("/sessions")
    fun createSession(@RequestBody session: Session): Session = sessionService.saveSession(session)

    @PutMapping("/sessions/{id}")
    fun updateSession(@PathVariable id: Long, @RequestBody session: Session): Session = sessionService.updateSession(id, session)

    @DeleteMapping("/sessions/{id}")
    fun deleteSession(@PathVariable id: Long): String = sessionService.deleteSession(id)
}