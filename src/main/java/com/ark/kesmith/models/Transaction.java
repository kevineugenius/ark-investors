package com.ark.kesmith.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int investor_id;
    private TransactionType type;
    private float amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    private int multiplier;

    public int getId() {
        return id;
    }

    public int getInvestor_id() {
        return investor_id;
    }

    public TransactionType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public Transaction() {}

    public Transaction(int investor_id, TransactionType type, float amount) {
        this.investor_id = investor_id;
        this.type = type;
        this.amount = amount;
        this.multiplier = type.getMultiplier(type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", investor_id=" + investor_id +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
