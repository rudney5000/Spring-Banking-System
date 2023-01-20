package com.dedyrudney.systembankingspring.service

import com.dedyrudney.systembankingspring.entity.Customer
import com.dedyrudney.systembankingspring.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService @Autowired private constructor(private val customerRepository: CustomerRepository){
    fun getAllCustomers(): List<Customer> = customerRepository.findAll()

    fun getCustomer(id: Long): Customer = customerRepository
        .findById(id)
        .orElseThrow {
            IllegalArgumentException("Customer with $id was not found")
        }
    fun saveCustomer(customer: Customer): Customer = customerRepository.save(customer)

    fun updateCustomer(id: Long, customerInput: Customer): Customer{
        val customerFound = getCustomer(id)

        customerFound.username = customerInput.username
        customerFound.fullname = customerInput.fullname
        customerFound.email = customerInput.email
        customerFound.password = customerInput.password
        customerFound.address = customerInput.address
        customerFound.city = customerInput.city
        customerFound.country = customerInput.country
//        customerFound.account = customerInput.account
        customerFound.dob = customerInput.dob
//        customerFound.card = customerInput.card
        customerFound.bank = customerInput.bank

        return customerRepository.save(customerFound)
    }

    fun deleteCustomer(id: Long): String{
        val customerFound = getCustomer(id)

        customerRepository.delete(customerFound)
        return "Customer deleted!"
    }

}