package com.pos.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Category extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String type;

    private String description;

    public Category(){

    }

    public Category(String type, String description) {
        this.type = type;
        this.description = description;
    }
    @Override
    public Long getId() {
        return id;
    }
}
