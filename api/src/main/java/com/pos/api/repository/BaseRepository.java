package com.pos.api.repository;

import com.pos.api.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseRepository<Entity extends BaseModel > extends JpaRepository<Entity, Long> {
}
