package com.ark.kesmith.controllers;

import com.ark.kesmith.repositories.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestorController {
    @Autowired
    private InvestorService investorService;


}
