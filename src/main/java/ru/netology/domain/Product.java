package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(int price) {
        this.price = price;
    }

    public void setPrice(String name) {
        this.name = name;
    }

    public boolean matches(String search) {
        if (name.contains(search)) {
            return true;
        } else {
            return false;
        }

    }

}
