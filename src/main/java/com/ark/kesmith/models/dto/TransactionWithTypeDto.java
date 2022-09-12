package com.ark.kesmith.models.dto;

import com.ark.kesmith.models.Transaction;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
public class TransactionWithTypeDto {
    private int transactionId;
    private int investorId;
    private String type;
    private float amount;
    private int fundId;
    private Date date;
}
