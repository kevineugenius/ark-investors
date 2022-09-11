package com.ark.kesmith.models;

public enum TransactionType {
    CONTRIBUTION,
    INTEREST_INCOME,
    DISTRIBUTION,
    GENERAL_EXPENSE,
    MANAGEMENT_FEE;

    public int getMultiplier(TransactionType t) {
        return (t.equals(TransactionType.CONTRIBUTION) ||
                t.equals(TransactionType.INTEREST_INCOME))
                ? 1 : -1;
    }
}
