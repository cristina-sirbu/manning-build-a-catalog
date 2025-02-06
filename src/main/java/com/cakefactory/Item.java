package com.cakefactory;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    final private String title;
    final private BigDecimal price;

    public Item(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }
}
