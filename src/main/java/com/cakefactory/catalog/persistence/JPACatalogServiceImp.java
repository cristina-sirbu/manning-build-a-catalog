package com.cakefactory.catalog.persistence;

import com.cakefactory.catalog.CatalogService;
import com.cakefactory.catalog.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JPACatalogServiceImp implements CatalogService {

    private final ItemRepository itemRepository;

    public JPACatalogServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        for(ItemEntity i:itemEntityList) {
            items.add(new Item(i.title, i.price));
        }
        return items;
    }
}
