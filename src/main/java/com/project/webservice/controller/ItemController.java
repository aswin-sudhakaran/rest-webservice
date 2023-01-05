package com.project.webservice.controller;

import com.project.webservice.model.Item;
import com.project.webservice.model.Response;
import com.project.webservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAllItems() {
        try {
            return new Response().successResponse(itemService.listAllItems());
        } catch (Exception e) {
            return new Response().failureResponse(e.getMessage());
        }
    }

    @PostMapping(value = "/additem")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        try {
            itemService.saveItem(item);
            return new ResponseEntity<>("Item:" + item + " saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Item:" + item + " not saved", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteItem(@RequestParam("id") Integer id) {
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>("Id:" + id + " deleted!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Id:" + id + " not deleted!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getitembyid")
    public ResponseEntity<?> getItemById(@RequestParam("id") Integer id) {
        try {
            return new Response().successResponse(itemService.getItem(id));
        } catch (Exception e) {
            return new Response().failureResponse(e.getMessage());
        }

    }

    @GetMapping(value = "/getitembybrand")
    public ResponseEntity<?> getItemByBrand(@RequestParam("name") String name) throws Exception {
        try {
            return new Response().successResponse(itemService.getItemByBrand(name));
        } catch (Exception e) {
            return new Response().failureResponse(e.getMessage());
        }
    }


    @GetMapping(value = "/getitemsbyids")
    public ResponseEntity<?> getItemsByIds(@RequestParam("id") List<Integer> requestParams) {
        try {
            return new Response().successResponse(itemService.findByIds(requestParams));
        } catch (Exception e) {
            return new Response().failureResponse(e.getMessage());
        }
    }

}
