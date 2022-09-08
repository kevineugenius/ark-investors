package com.ark.kesmith.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Investor {
    @Id
    private int id;
    private int createdBy;
    private String name;

    public int getId() {
        return id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public String getName() {
        return name;
    }

    protected Investor() {};

    public Investor(int createdBy, String name) {
        this.createdBy = createdBy;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", name='" + name + '\'' +
                '}';
    }
}
