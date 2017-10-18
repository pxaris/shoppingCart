package com.example.controllers;

import com.example.models.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest {

    @Mock
    ItemRepository itemRepository;

    ItemController itemController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.itemController = new ItemController(itemRepository);
    }

    @Test
    public void testGetItems() {
        this.itemController.getItems();
        verify(itemRepository, times(1)).findAll();
    }
}