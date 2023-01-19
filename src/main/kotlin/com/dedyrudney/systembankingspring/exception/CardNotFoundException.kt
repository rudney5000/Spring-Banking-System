package com.dedyrudney.systembankingspring.exception

import org.springframework.http.HttpStatus

class CardNotFoundException(val statusCode: HttpStatus, val reason: String): Exception()