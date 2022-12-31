package com.project.webservice.controller;

import com.project.webservice.model.Item;
import com.project.webservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return itemService.listAllItems();
    }

    @RequestMapping(value = "/getitembyid", method = RequestMethod.GET)
    public ResponseEntity<Item> getItemById(@RequestParam("id") Integer id) {
        try {
            Item item = itemService.getItem(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getitemsbyids", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> saveUser(@RequestParam("id") List<Integer> requestParams) {
        try {
            List<Item> itemList = itemService.findByIds(requestParams);
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteItem(@RequestParam("id") Integer id) {

        itemService.deleteItem(id);
    }
}
