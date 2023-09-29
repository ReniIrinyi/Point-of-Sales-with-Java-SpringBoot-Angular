package com.pos.api.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invoice extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Employee employee;

    private double total;

    private double vat;

    private double discount;

    private double payable;

    private double paid;

    private double returned;

    private String date;

    public Invoice() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public Invoice(Employee employee, double total, double vat,
                   double discount, double payable, double paid, double returned, String date) {
        this.employee = employee;
        this.total = total;
        this.vat = vat;
        this.discount = discount;
        this.payable = payable;
        this.paid = paid;
        this.returned = returned;
        this.date = date;
    }
}
