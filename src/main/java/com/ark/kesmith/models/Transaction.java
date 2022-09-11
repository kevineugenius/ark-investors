package com.ark.kesmith.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int investor_id;
    private int type;
    private float amount;
    private int fund_id;
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Transient
    private int multiplier;

    public int getId() {
        return id;
    }

    public int getInvestor_id() {
        return investor_id;
    }

    public int getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public int getFund_id() { return fund_id; }

    public int getMultiplier() { return multiplier; }

    public void setMultiplier(int m) { multiplier = m; }

    public Transaction() {}

    public Transaction(int investor_id, int fund_id, int type, float amount) {
        this.investor_id = investor_id;
        this.fund_id = fund_id;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", investor_id=" + investor_id +
                ", type=" + type +
                ", fund_id=" + fund_id +
                ", amount=" + amount +
                // this does actually work in the database but prints out null on creation; might be a jpa quirk from the transient tag
                ", date=" + date +
                '}';
    }
}
