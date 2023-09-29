package com.pos.api.controller;

import com.pos.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

    public abstract class BaseRestController<Entity extends BaseModel, JPARepository extends JpaRepository<Entity, Long> & PagingAndSortingRepository<Entity, Long>> {

        public BaseRestController(){}

        protected abstract JPARepository getRepository();

        @PostMapping
        public ResponseEntity<Entity> post(@RequestBody Entity obj) {
            Entity result = this.getRepository().save(obj);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }

        @PutMapping({"/{id}"})
        public ResponseEntity<Entity> put(@RequestBody Entity obj, @PathVariable("id") Long id) {
            if (obj.getId() != null && !Objects.equals(obj.getId(), id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity ID and Path ID do not match");
            } else if (id != null && !this.getRepository().existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found");
            } else {
                Entity result = this.getRepository().save(obj);
                return new ResponseEntity(result, HttpStatus.OK);
            }
        }

        @GetMapping({"/{id}"})
        public ResponseEntity<Entity> get(@PathVariable("id") Long id) {
            if (!this.getRepository().existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found");
            } else {
                Entity result = this.getRepository().findById(id).get();
                return new ResponseEntity(result, HttpStatus.OK);
            }
        }


        @DeleteMapping({"/{id}"})
        public ResponseEntity<Entity> delete(@PathVariable("id") Long id) {
            if (!this.getRepository().existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found");
            } else {
                Entity result = this.getRepository().findById(id).get();
                this.getRepository().deleteById(id);
                return new ResponseEntity(result, HttpStatus.OK);
            }
        }


}
