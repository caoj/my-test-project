package com.cj.study.spring.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Disabled
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetEndpoint() throws Exception {
        mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk());
    }
}