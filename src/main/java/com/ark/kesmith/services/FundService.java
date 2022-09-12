package com.ark.kesmith.services;

import com.ark.kesmith.models.Fund;
import com.ark.kesmith.repositories.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {
    @Autowired
    private FundRepository fundRepository;

    public Fund addFund(Fund fund) {
        return fundRepository.save(fund);
    }

    public Fund getFundById(int id) {
        return fundRepository.findById(id).get();
    }
}
