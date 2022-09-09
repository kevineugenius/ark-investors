package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Fund;
import com.ark.kesmith.services.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fund")
@RestController
public class FundController {
    @Autowired
    private FundService fundService;

    @PostMapping("/add")
    public void addFund(@RequestBody Fund fund) { // todo: add client here in a requestobject
        System.out.println("Fund service returned: " + fundService.addFund(fund));
    }
}
