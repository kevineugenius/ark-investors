package com.ark.kesmith.integration;

import com.ark.kesmith.controllers.InvestorController;
import com.ark.kesmith.models.Investor;
import com.ark.kesmith.repositories.InvestorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.StreamSupport;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvestorIntegrationTest {
    @Autowired
    private InvestorController investorController;

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testAdd() throws Exception {
        String body = "{\"createdBy\":1,\"name\":\"Tester Investor\"}";
        // pull this out into a setup method
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Iterable<Investor> investorsOriginal = investorRepository.findAll();

        mvc.perform(
                post("/investor/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andExpect(status().isOk());

        Iterable<Investor> investorsAfter = investorRepository.findAll();

        assert(StreamSupport.stream(investorsAfter.spliterator(), false).count() -
                StreamSupport.stream(investorsOriginal.spliterator(), false).count() == 1);
    }
}
