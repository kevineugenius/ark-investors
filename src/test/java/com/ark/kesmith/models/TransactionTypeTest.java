package com.ark.kesmith.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {

    @Test
    void getMultiplier() {
        Transaction positiveTransaction1 = new Transaction(
                0, TransactionType.CONTRIBUTION, 50.99f
        );
        assertEquals(positiveTransaction1.getMultiplier(), 1);

        Transaction positiveTransaction2 = new Transaction(
                0, TransactionType.INTEREST_INCOME, 1.00f
        );
        assertEquals(positiveTransaction2.getMultiplier(), 1);

        Transaction negativeTransaction1 = new Transaction(
                0, TransactionType.DISTRIBUTION, 100f
        );
        assertEquals(negativeTransaction1.getMultiplier(), -1);

        Transaction negativeTransaction2 = new Transaction(
                0, TransactionType.MANAGEMENT_FEE, 66.77f
        );
        assertEquals(negativeTransaction2.getMultiplier(), -1);

        Transaction negativeTransaction3 = new Transaction(
                0, TransactionType.GENERAL_EXPENSE, 7.01f
        );
        assertEquals(negativeTransaction3.getMultiplier(), -1);
    }
}