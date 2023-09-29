package com.pos.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment extends BaseModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double subTotal;
        private double vat;
        private double discount;
        private double payable;

        public Payment(double subTotal, double vat, double discount, double payable) {
            this.subTotal = subTotal;
            this.vat = vat;
            this.discount = discount;
            this.payable = payable;
        }

    @Override
    public Long getId() {
        return null;
    }

}
