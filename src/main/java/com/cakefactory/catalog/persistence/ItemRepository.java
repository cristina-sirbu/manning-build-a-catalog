package com.cakefactory.catalog.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, String> {
    List<ItemEntity> findAll();
}
