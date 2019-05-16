package com.microservices.chapter3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService:CustomServiceImpl

    @GetMapping(value = "/customers")
    fun getCustomers(@RequestParam(required = false,defaultValue = "")
    nameFilter: String) =customerService.searchCustomer(nameFilter)

    @GetMapping(value ="/customer/{id}")
    fun getCustomer(@PathVariable id: Int) : ResponseEntity<Customer?>  {
            val customer = customerService.getCustomer(id)
            val status = if(customer == null) HttpStatus.NOT_FOUND else HttpStatus.OK
            return ResponseEntity(customer,status)
        }

    @PostMapping(value = "/customer/")
    fun createCustomer(@RequestBody customer: Customer) {customerService.createCustomer(customer)}

    @DeleteMapping(value = "/customer/{id}")
    fun delleteCustomer(@PathVariable id: Int) {customerService.deleteCustomer(id)}

    @PutMapping(value = "/customer/{id}")
    fun updateCustomer(@PathVariable id: Int,@RequestBody customer: Customer)
    {customerService.updateCustomer(id,customer)}

}