package com.cakefactory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryCatalogServiceImpl implements CatalogService {
    @Override
    public List<Item> getItems() {
        return List.of(
                new Item("Test item 1", BigDecimal.valueOf(1.95)),
                new Item("Test item 2", BigDecimal.valueOf(4.99)),
                new Item("Test item 3", BigDecimal.valueOf(3.95)));
    }
}
