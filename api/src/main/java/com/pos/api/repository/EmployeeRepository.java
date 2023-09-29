package com.pos.api.repository;

import com.pos.api.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);
}
