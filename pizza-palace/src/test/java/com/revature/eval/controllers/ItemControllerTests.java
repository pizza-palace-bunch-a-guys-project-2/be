package com.revature.eval.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.ItemController;
import com.revature.log.ItemLog;
import com.revature.models.Item;
import com.revature.services.ItemService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemServ;
    
    @MockBean
    private ItemLog itemLog;

    private Item testItem0;
    private List<Item> testList;

    @BeforeEach
    public void setUp() throws Exception{

    	testItem0 = new Item("Type", "item", 0, "#", "description");
    	when(itemServ.insertItem(testItem0)).thenReturn(testItem0);
    	testList = new ArrayList<Item>();
    	testList.add(testItem0);
    	
    }

    @Test
    public void testInsertOrderSuccess() throws Exception {

            this.mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testItem0)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(testItem0.getItemName() + " inserted"));
    }
    
    @Test
    public void testGetAllItems() throws Exception {
    	this.mockMvc.perform(get("/items"))
		.andExpect(status().isOk());
    }
    
    
    
}