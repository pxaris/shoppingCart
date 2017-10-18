package com.example.controllers;

import com.example.models.CartOrder;
import com.example.models.Item;
import com.example.models.ItemRepository;
import com.example.models.OrderRepository;
import org.assertj.core.api.Assertions;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ItemRepository itemRepository;

    CartController cartController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.cartController = new CartController(orderRepository, itemRepository);
    }

    @Test
    public void testGetOrders() {
        this.cartController.getOrders();
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testAddOrder() {
        int itemId = 1;
        Item testItem = new Item("laptop", 0.3, 500, "hp_laptop1.jpg");
        when(itemRepository.findOne(itemId)).thenReturn(testItem);
        CartOrder mockCartOrder = new CartOrder(testItem, 1);
        when(orderRepository.save(Matchers.any(CartOrder.class))).thenReturn(mockCartOrder);
        CartOrder actualCartOrder = cartController.addOrder(itemId);
        assertThat(actualCartOrder, samePropertyValuesAs(mockCartOrder));
        verify(orderRepository, times(1)).save(any(CartOrder.class));
    }

    @Test
    public void testChangeQuantity() {
        int orderId = 2;
        int quantity = 5;
        Item testItem = new Item("laptop", 0.3, 500, "hp_laptop1.jpg");
        CartOrder mockCartOrder = new CartOrder(testItem, 1);
        mockCartOrder.setQuantity(quantity);
        when(orderRepository.findOne(orderId)).thenReturn(mockCartOrder);
        cartController.changeQuantity(orderId, quantity);
        verify(orderRepository, times(1)).findOne(orderId);
        verify(orderRepository, times(1)).save(mockCartOrder);
    }

    @Test
    public void testDeleteOrder() {
        int orderId = 4;
        cartController.deleteOrder(orderId);
        verify(orderRepository, times(1)).delete(orderId);
    }

}