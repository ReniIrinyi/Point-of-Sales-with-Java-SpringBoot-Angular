package com.pos.api.controller;

import com.pos.api.model.Employee;
import com.pos.api.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController extends BaseRestController<Employee, EmployeeRepository> {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @Override
    protected EmployeeRepository getRepository() {
        return this.repository;
    }


}
