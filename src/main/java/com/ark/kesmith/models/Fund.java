package com.ark.kesmith.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fund {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    public Fund(int createdBy, String name) {
        this.createdBy = createdBy;
        this.name = name;
    }

    public Fund() {}

    @Override
    public String toString() {
        return "Fund{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", name='" + name + '\'' +
                '}';
    }
}
