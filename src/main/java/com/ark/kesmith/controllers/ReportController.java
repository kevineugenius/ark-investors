package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Transaction;
import com.ark.kesmith.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/fund-transactions/{fundId}")
    public List<Transaction> getFundTransactionsById(@PathVariable int fundId) {
        return reportService.getFundTransactionsById(fundId);
    }

    @GetMapping("/fund-transactions/{fundId}/investor/{investorId}")
    public Map<String, Object> getFundTransactionsByIdAndInvestorId(@PathVariable int fundId, @PathVariable int investorId) {
        return reportService.getFundTransactionsReportByIdAndInvestorId(fundId, investorId);
    }
}
