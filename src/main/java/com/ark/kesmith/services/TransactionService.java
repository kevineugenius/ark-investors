package com.ark.kesmith.services;

import com.ark.kesmith.models.Transaction;
import com.ark.kesmith.models.TransactionType;
import com.ark.kesmith.repositories.TransactionRepository;
import com.ark.kesmith.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public Transaction addTransaction(Transaction transaction) {
        // todo: does this person have authorization to make transactions on the fund?
        return transactionRepository.save(transaction);
    }

    // todo: all transaction gets need to have dates and multipliers filled in
    public List<Transaction> getFundTransactionsById(int fundId) {
        return transactionRepository.findByFundId(fundId);
    }

    public List<Transaction> getFundTransactionsByIdAndInvestorId(int fundId, int investorId) {
        return transactionRepository.findByFundIdAndInvestorId(fundId, investorId);
    }

    public Iterable<TransactionType> getAllTransactionTypes() {
        return transactionTypeRepository.findAll();
    }
}
