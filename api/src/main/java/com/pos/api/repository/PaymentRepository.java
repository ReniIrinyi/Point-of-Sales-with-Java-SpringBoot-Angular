package com.pos.api.repository;

import com.pos.api.model.Payment;
import com.pos.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment> {
}
