package com.project.webservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    private int id;
    private float price;
    private String description;
    private String brand;

}
