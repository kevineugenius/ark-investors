package com.ark.kesmith.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private int multiplier;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public TransactionType() {}

    public TransactionType(String name, int multiplier) {
        this.name = name;
        if (multiplier * multiplier == 1) {
            this.multiplier = multiplier;
        } else {
            throw new RuntimeException("Invalid multiplier value.");
        }
    }
}
