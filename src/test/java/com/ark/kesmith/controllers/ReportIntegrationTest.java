package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Transaction;
import com.ark.kesmith.services.ReportService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportIntegrationTest {
    @Autowired
    private ReportController reportController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @BeforeAll // change to BeforeEach if context is too dirty to be useful for added tests
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup((webApplicationContext)).build();
    }

    // todo: other tests aren't following this naming convention, but they should
    @Test
    public void getFundTransactionsById_givenValidData_shouldReturnJsonData() throws Exception {
        // todo: move to a file?
        String expectedResult = "[" +
                "{\"id\":1,\"investorId\":1,\"type\":1,\"amount\":40.4,\"fundId\":1,\"date\":null,\"multiplier\":0}," +
                "{\"id\":2,\"investorId\":1,\"type\":1,\"amount\":41.41,\"fundId\":1,\"date\":null,\"multiplier\":0}," +
                "{\"id\":3,\"investorId\":1,\"type\":3,\"amount\":42.24,\"fundId\":1,\"date\":null,\"multiplier\":0}," +
                "{\"id\":4,\"investorId\":2,\"type\":1,\"amount\":140.1,\"fundId\":1,\"date\":null,\"multiplier\":0}," +
                "{\"id\":5,\"investorId\":2,\"type\":4,\"amount\":240.2,\"fundId\":1,\"date\":null,\"multiplier\":0}," +
                "{\"id\":6,\"investorId\":2,\"type\":2,\"amount\":340.3,\"fundId\":1,\"date\":null,\"multiplier\":0}]";

        mvc.perform(get("/report/fund-transactions/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    public void getFundTransactionsByIdAndInvestorId_givenValidData_shouldReturnJsonData() throws Exception {
        String expectedResult = "{\"Transactions\":[" +
                "{\"transactionId\":4,\"investorId\":2,\"type\":\"contribution\",\"amount\":140.1,\"fundId\":1,\"date\":null}," +
                "{\"transactionId\":5,\"investorId\":2,\"type\":\"general expense\",\"amount\":-240.2,\"fundId\":1,\"date\":null}," +
                "{\"transactionId\":6,\"investorId\":2,\"type\":\"interest income\",\"amount\":340.3,\"fundId\":1,\"date\":null}]," +
                "\"Fund\":{\"id\":1,\"createdBy\":1,\"name\":\"Phils Fund\"}," +
                "\"Investor\":{\"id\":2,\"createdBy\":3,\"name\":\"Filipa\"}}\n";

        mvc.perform(get("/report/fund-transactions/1/investor/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((content().json(expectedResult)));
    }
}
