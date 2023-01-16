package io.liksi.blog.demospringdoccoffee.controller

import io.liksi.blog.demospringdoccoffee.Roles
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
@Tag(name = "Order controller")
class OrderCtrl {

    @Secured(Roles.BARISTA, Roles.OWNER)
    @GetMapping
    @Operation(summary = "Get all customers orders")
    fun getAllOrders() {}

    @Secured(Roles.CUSTOMER)
    @PostMapping
    @Operation(summary = "Place an order")
    fun placeOrder() {}

    @Secured(Roles.BARISTA)
    @PutMapping("/{id}/prepare")
    @Operation(summary = "Prepare order")
    fun prepareOrder(@PathVariable id: String) {}

    @Secured(Roles.BARISTA)
    @PutMapping("{id}/serve")
    @Operation(summary = "Serve order")
    fun serveOrder(@PathVariable id: String) {}

}