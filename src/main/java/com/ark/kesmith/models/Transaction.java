package com.ark.kesmith.models;

import javax.persistence.*;
import java.util.Date;

// todo: this class is inconsistent with the others right now; the others need to be updated to camelcase fields
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int investorId;
    private int type;
    private float amount;
    private int fundId;
    // todo: dates are built in the database but they aren't returned at all.  transient is the wrong tag.
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // todo: should this go into the DTO?
    @Transient
    private int multiplier;

    public int getId() {
        return id;
    }

    public int getInvestorId() {
        return investorId;
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

    public int getFundId() { return fundId; }

    public int getMultiplier() { return multiplier; }

    public void setMultiplier(int m) { multiplier = m; }

    public Transaction() {}

    public Transaction(int investorId, int fundId, int type, float amount) {
        this.investorId = investorId;
        this.fundId = fundId;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", investorId=" + investorId +
                ", type=" + type +
                ", amount=" + amount +
                ", fundId=" + fundId +
                ", date=" + date +
                '}';
    }
}
