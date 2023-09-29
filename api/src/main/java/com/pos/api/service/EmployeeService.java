package com.pos.api.service;

import com.pos.api.model.Employee;
import com.pos.api.model.enums.Role;
import com.pos.api.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        if(this.employeeRepository.existsByEmail("admin@posApp.de")){
            Employee employee=new Employee();
            employee.setEmail("admin@posApp.de");
            employee.setRole(Role.Admin);
            employee.setPassword(passwordEncoder.encode("admin"));
            this.employeeRepository.save(employee);
        }
    }

    /**
     * Creates a new Employee in the database.
     *
     * @param email    identifier within the database
     * @param password password in cleartext
     * @throws ResponseStatusException email exists already
     */
    public void newEmployee(String email, String password) {
        if (this.employeeRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-Mail exists");
        }

        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setPassword(passwordEncoder.encode(password));

        this.employeeRepository.save(employee);
    }

    /**
     * Updates the password of an Employee within the database
     *
     * @param email identifier within the database
     * @param password updated password in cleartext
     * @throws ResponseStatusException no user found with the given email
     */
    public void updatePassword(String email, String password) {
        Optional<Employee> optEmployee = this.employeeRepository.findByEmail(email);

        if(optEmployee.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-Mail doesn't exist");
        }

        Employee employee = optEmployee.get();
        employee.setPassword(passwordEncoder.encode(password));
        this.employeeRepository.save(employee);
    }

    /**
     * Verifies whether the given credentials match an Employee in the database
     * or else throws {@link ResponseStatusException}
     *
     * @param email identifier within the database
     * @param password password in cleartext
     * @throws ResponseStatusException email doesn't exists
     * @return matched Employee
     */
    public Employee authenticate(String email, String password) {
        Optional<Employee> optEmployee = this.employeeRepository.findByEmail(email);
        if (optEmployee.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "E-Mail does not exist");
        Employee employee = optEmployee.get();
        if (!passwordEncoder.matches(password, employee.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        return employee;
    }

}
