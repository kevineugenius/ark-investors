package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Investor;
import com.ark.kesmith.services.InvestorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InvestorController.class)
class InvestorControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private InvestorService investorService;

    @Test
    void addInvestor() throws Exception {
        // given
        String body = "{\"createdBy\":0,\"name\":\"Tester Investor\"}";

        // when
        Mockito.when(investorService.addInvestor(any()))
                .thenReturn(new Investor(0, "Tester Investor"));

        // then
        mvc.perform(
            post("/investor/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
        ).andExpect(status().isOk());
    }
}