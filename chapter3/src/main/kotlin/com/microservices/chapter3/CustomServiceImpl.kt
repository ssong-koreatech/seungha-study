package com.microservices.chapter3

import java.util.concurrent.ConcurrentHashMap
import org.springframework.stereotype.Component

@Component
class CustomServiceImpl : CustomService {
    companion object {
        val initialCustomers = arrayOf(
                Customer(1,"Kotilin"),
                Customer(2,"Spring"),
                Customer(3,"MicroService"))
    }
    val customers = ConcurrentHashMap<Int,Customer>(initialCustomers.associateBy(Customer::id))

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomer(nameFilter: String): List<Customer> {
        return customers.filter{
            it.value.name.contains(nameFilter,true)
        }.map(Map.Entry<Int,Customer>::value).toList()
    }

    override fun getCustomer(id: Int): Customer? {
        return customers[id]
    }
}