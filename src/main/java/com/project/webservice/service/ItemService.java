package com.project.webservice.service;

import com.project.webservice.model.Item;
import com.project.webservice.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemService {

        @Autowired
        private ItemRepository itemRepository;
        public List<Item> listAllItems() {
            List<Item> output= itemRepository.findAll();
            return output
                    .stream()
                    .sorted(Comparator.comparing(Item::getPrice).reversed())
                    .collect(Collectors.toList());
        }

        public void saveItem(Item user) {
            itemRepository.save(user);
        }

        public Item getItem(Integer id) {
            return itemRepository.findById(id).get();
        }

        public void deleteItem(Integer id) {
            itemRepository.deleteById(id);
        }

         public List<Item> findByIds(List<Integer> idList) {
            List<Item> itemList = new ArrayList<>();
            idList.forEach((n)->itemList
                    .add(itemRepository.findById(n).get()));
            return itemList;
    }

}
