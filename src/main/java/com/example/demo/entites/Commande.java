package com.example.demo.entites;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString @NoArgsConstructor
@Entity(name = "orderTable")
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;
    @Getter @Setter
    private int quantity;
    @Getter @Setter
    private double unitPrice;
    @Getter
    private double totalPrice;

    
    
    public Commande(Integer id, int quantity, double unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    
    
    public void calculateTotalPrice(int quantity, double unitPrice) {
        this.totalPrice = quantity*unitPrice;
    }

}
