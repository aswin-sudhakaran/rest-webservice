package com.project.webservice.repository;

import com.project.webservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByBrand(String name);

 }
