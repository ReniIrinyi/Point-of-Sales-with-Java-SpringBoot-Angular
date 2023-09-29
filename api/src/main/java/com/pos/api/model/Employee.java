package com.pos.api.model;

import com.pos.api.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Data
public class Employee extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NonNull
    private Role role;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String userName;
    @NonNull
    private  String email;
    @NonNull
    private  String password;

    private String phone;

    private String address;

    public Employee(){
    }

    public Employee( @NonNull Role role, @NonNull String firstName, @NonNull String lastName, @NonNull String userName, @NonNull String email, @NonNull String password, String phone, String address) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
     else if (o != null && this.getClass() == o.getClass()) {
        Employee employee = (Employee) o;
        return this.id.equals(employee.id) && this.email.equals(employee.email) && this.password.equals(employee.password);
    }else {
     return false;
     }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
    @Override
    public Long getId() {
        return id;
    }
    }
