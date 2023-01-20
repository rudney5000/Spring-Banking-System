package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Session
import com.dedyrudney.systembankingspring.exception.SessionNotFoundException
import com.dedyrudney.systembankingspring.repository.SessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SessionService @Autowired private constructor(private var sessionRepository: SessionRepository){

    fun getAllSession(): List<Session> = sessionRepository.findAll()

    fun getSession(id: Long): Session = sessionRepository
        .findById(id)
        .orElseThrow {
            SessionNotFoundException("Session with this $id was not found!")
        }

    fun saveSession(session: Session): Session = sessionRepository.save(session)

    fun updateSession(id: Long, sessionInput: Session): Session {
        val sessionToUpdate = getSession(id)

        sessionToUpdate.lastMessage = sessionInput.lastMessage
        sessionToUpdate.number = sessionInput.number
        sessionToUpdate.transaction = sessionInput.transaction
        sessionToUpdate.atm = sessionInput.atm

        return sessionRepository.save(sessionToUpdate)
    }

    fun deleteSession(id: Long): String{
        val sessionDelete = getSession(id)

        sessionRepository.deleteById(id)

        return "Session Deleted!"
    }
}