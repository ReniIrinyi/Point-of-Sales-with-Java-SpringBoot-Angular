package com.pos.api.repository;

import com.pos.api.model.Product;
import com.pos.api.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends BaseRepository<Supplier> {
}
