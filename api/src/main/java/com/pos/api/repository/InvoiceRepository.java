package com.pos.api.repository;

import com.pos.api.model.Invoice;
import com.pos.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice> {
}
