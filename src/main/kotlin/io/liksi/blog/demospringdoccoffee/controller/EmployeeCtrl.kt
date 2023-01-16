package io.liksi.blog.demospringdoccoffee.controller

import io.liksi.blog.demospringdoccoffee.Roles
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
@Secured(Roles.OWNER)
@Tag(name = "Employee controller")
class EmployeeCtrl {
    @GetMapping
    @Operation(summary = "Get all employees")
    fun getAllEmployees() {}

    @GetMapping("/{id}")
    @Operation(summary = "Get one employee")
    fun getOneEmployee(@PathVariable id: String) {}

    @PostMapping
    @Operation(summary = "Create an employee")
    fun createEmployee() {}

    @PutMapping
    @Operation(summary = "Update an employee")
    fun updateEmployee() {}

    @DeleteMapping
    @Operation(summary = "Delete an employee")
    fun deleteEmployee() {}
}