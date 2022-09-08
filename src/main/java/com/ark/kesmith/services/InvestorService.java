package com.ark.kesmith.services;

import com.ark.kesmith.models.Investor;
import com.ark.kesmith.repositories.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorService {
    @Autowired
    private InvestorRepository investorRepository;

    public Investor addInvestor(Investor investor) {
        return investorRepository.save(investor);
    }
}
