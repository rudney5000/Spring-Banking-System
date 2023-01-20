package com.dedyrudney.systembankingspring.controller

import com.dedyrudney.systembankingspring.entity.Customer
import com.dedyrudney.systembankingspring.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired private constructor(private val customerService: CustomerService){
    @GetMapping("/customers")
    fun getCustomerList(): List<Customer> = customerService.getAllCustomer()

    @GetMapping("/customers/{id}")
    fun getCustomer(@PathVariable id: Long): Customer = customerService.getCustomer(id)

    @PostMapping("/customers")
    fun createCustomer(@RequestBody customer: Customer): Customer = customerService.saveCustomer(customer)

    @PutMapping("/customers/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer): Customer = customerService.updateCustomer(id, customer)

    @DeleteMapping("/customers/{id}")
    fun deleteCustomer(@PathVariable id: Long): String = customerService.deleteCustomer(id)
}