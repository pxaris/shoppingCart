package com.example;

import com.example.controllers.CartController;
import com.example.controllers.ItemController;
import com.example.models.ItemRepository;
import com.example.models.OrderRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingcartApplicationTests {

    @Autowired
    private CartController cartController;

    @Autowired
    private ItemController itemController;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired 
    private OrderRepository orderRepository;

    @Test
    public void contextLoads() {
        assertThat(cartController).isNotNull();
        assertThat(itemController).isNotNull();
        assertThat(itemRepository).isNotNull();
        assertThat(orderRepository).isNotNull();
    }

}