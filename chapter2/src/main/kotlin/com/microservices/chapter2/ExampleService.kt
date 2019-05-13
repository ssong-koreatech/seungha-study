package com.microservices.chapter2

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value

class ExampleService : ServiceInterface{
    @Value(value= "\${service.message.text}")
    private lateinit var text:String

    override fun getHello(name: String ): String = "$text $name"
}