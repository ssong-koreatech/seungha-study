package com.microservices.chapter4

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun createCustomer(customer: Customer)
    fun deleteCustomer(id : Int)
    fun updateCustomer(id: Int, customer:Customer)
    fun searchCustomer(nameFilter:String): List<Customer>
}