package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Investor;
import com.ark.kesmith.services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestorController {
    @Autowired
    private InvestorService investorService;

    /*
    I don't want this to remain a POST forever but for now it makes sense as adding
    the "same" investor won't be detected or rejected.
     */
    @PostMapping("/investor/add")
    public void addInvestor(@RequestBody Investor investor) {
        System.out.println("The service returned: " + investorService.addInvestor(investor));
    }
}
