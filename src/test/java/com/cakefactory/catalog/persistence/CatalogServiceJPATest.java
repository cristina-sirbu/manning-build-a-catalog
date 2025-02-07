package com.cakefactory.catalog.persistence;

import com.cakefactory.catalog.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CatalogServiceJPATest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    ItemRepository itemRepository;

    private JPACatalogServiceImp jpaCatalogServiceImp;

    @BeforeEach
    void setUp() {
        this.jpaCatalogServiceImp = new JPACatalogServiceImp(itemRepository);
    }


    @Test
    @DisplayName("returns data from the database")
    void testExample() {
        ItemEntity testItem = new ItemEntity();
        testItem.sku = "test-item-1";
        testItem.title = "Test item";
        testItem.price = BigDecimal.valueOf(10);

        this.entityManager.persistAndFlush(testItem);
        List<Item> items = jpaCatalogServiceImp.getItems();
        Item item = items.get(0);
        assertThat(item.getTitle()).isEqualTo(testItem.title);
        assertThat(item.getPrice()).isEqualTo(testItem.price);
    }
}
