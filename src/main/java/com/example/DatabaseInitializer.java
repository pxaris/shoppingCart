package com.example;

import com.example.models.Item;
import com.example.models.ItemRepository;
import com.example.models.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner {


    @Autowired
    ItemRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        repository.save(new Item("tablet", 0.2, 150, "tablet1.jpg"));
        repository.save(new Item("laptop", 0.3, 500, "hp_laptop1.jpg"));
        repository.save(new Item("smartphone", 0.1, 200, "smartphone1.jpg"));
        repository.save(new Item("speakers", 0.5, 80, "speakers1.jpg"));
        repository.save(new Item("desktop", 1, 1000, "desktop1.jpg"));
        repository.save(new Item("keyboard", 0.1, 50, "keyboard1.jpg"));

    }

}
