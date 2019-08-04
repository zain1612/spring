package com.zain.javacoffee.controller;

import com.zain.javacoffee.model.Friend;
import com.zain.javacoffee.service.FriendService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sun.security.validator.ValidatorException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendController.class)
public class FriendControllerTest {

    @MockBean
    FriendService friendService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testCreateRead() throws Exception {
        Friend friend = new Friend("ben","stokes");
        List<Friend> friends = Arrays.asList(friend);

        Mockito.when(friendService.findAll()).thenReturn(friends);

        mockMvc.perform(get("/friend"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("ben")));
    }

}