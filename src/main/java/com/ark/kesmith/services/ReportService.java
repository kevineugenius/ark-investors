package com.ark.kesmith.services;

import com.ark.kesmith.models.Fund;
import com.ark.kesmith.models.Investor;
import com.ark.kesmith.models.Transaction;
import com.ark.kesmith.models.TransactionType;
import com.ark.kesmith.models.dto.TransactionWithTypeDto;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
public class ReportService {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private InvestorService investorService;

    @Autowired
    private FundService fundService;

    public List<Transaction> getFundTransactionsById(int fundId) {
        // still raw
        return transactionService.getFundTransactionsById(fundId);
    }

    /*
     * Report intended to give an investor the history of what they've done in a specific fund, for example.
     */
    public Map<String, Object> getFundTransactionsReportByIdAndInvestorId(int fundId, int investorId) {
        // raw
        List<Transaction> transactions = transactionService.getFundTransactionsByIdAndInvestorId(fundId, investorId);
        // to make not raw:
        // get investor by id
        Investor investor = investorService.getInvestorById(investorId);
        // get fund by id
        Fund fund = fundService.getFundById(fundId);
        // get transaction types
        List<TransactionType> transactionTypes =
                StreamSupport.stream(
                        transactionService.getAllTransactionTypes().spliterator(), false)
                        .toList();

        // add information from transaction type to transaction
        List<TransactionWithTypeDto> transactionWithTypeDtos = new ArrayList<>();
        transactions.stream().forEach(t -> {
            try {
                transactionWithTypeDtos.add(TransactionWithTypeDto.builder()
                        .transactionId(t.getId())
                        .investorId(t.getInvestorId())
                        .type(findTransactionTypeString(transactionTypes, t.getType()))
                        .amount(t.getAmount() * findTransactionTypeMultiplier(transactionTypes, t.getType()))
                        .fundId(t.getFundId())
                        .date(t.getDate())
                        .build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // collect everything
        Map<String, Object> result = new HashMap<>();
        result.put("Fund", fund);
        result.put("Investor", investor);
        result.put("Transactions", transactionWithTypeDtos);

        return result;
    }

    // todo: these helper methods make me think this whole process should move into a utility class perhaps
    private String findTransactionTypeString(List<TransactionType> typeList, int typeId) {
        for (TransactionType t : typeList) {
            if (t.getId() == typeId) {
                return t.getName();
            }
        };
        return null;
    }

    private int findTransactionTypeMultiplier(List<TransactionType> typeList, int typeId) throws Exception {
        for (TransactionType t : typeList) {
            if (t.getId() == typeId) {
                return t.getMultiplier();
            }
        };
        throw new Exception("Multiplier lookup failed.");
    }
}
