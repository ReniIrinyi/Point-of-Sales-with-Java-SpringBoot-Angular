package com.pos.api.service;

import com.pos.api.model.Category;
import com.pos.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService <Entity, ID> {

    private final JpaRepository<Entity, ID> repository;

    @Autowired
    public BaseService(JpaRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    public Entity create(Entity entity){
        return this.repository.save(entity);
    }


    public List<Entity> getAll(){
        return this.repository.findAll();
    }

    public void getById(ID id){
        this.repository.getReferenceById(id);
    }

    public void update(Entity entity, ID id){
        Optional<Entity> optEntity=this.repository.findById(id);
        if(optEntity.isPresent()){
            Entity exEntity=optEntity.get();
            this.repository.save(exEntity);
        } else {
            throw new RuntimeException("Entity: " + entity.toString()+  " doesn't exist");
        }
    }

    public void deleteById(Entity entity){
        this.repository.delete(entity);
    }

}
