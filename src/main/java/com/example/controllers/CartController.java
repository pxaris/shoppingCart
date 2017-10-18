package com.example.controllers;

import com.example.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    OrderRepository orderRepository;

    ItemRepository itemRepository;

    @Autowired
    public CartController(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cart getOrders() {
        return new Cart(orderRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public CartOrder addOrder(@RequestBody Integer itemId) {
        Item item = itemRepository.findOne(itemId);
        CartOrder order = new CartOrder(item, 1);
        orderRepository.save(order);
        return order;
    }

   @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    public void changeQuantity(@PathVariable Integer orderId, @RequestBody Integer quantity) {
       CartOrder order = orderRepository.findOne(orderId);
       order.setQuantity(quantity);
       orderRepository.save(order);
    }


    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable Integer orderId) {
        orderRepository.delete(orderId);
    }

}
