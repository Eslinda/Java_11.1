package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ManagerTest {

    ProductRepository repo = new ProductRepository();
    Product book = new Book(765, "The Assassination Bureau", 1750, "Jack London");
    Product phone = new Smartphone(12, "Redmi Note 11S", 26700, "Xiaomi");
    Product book1 = new Book(133, "The Road with No Return", 750, "Andrzej Sapkowski");
    Product phone1 = new Smartphone(6897, "Galaxy A32", 26000, "Samsung");
    Product book2 = new Book(6, "The Stone Guest", 380, "Alexander Pushkin");
    Product phone2 = new Smartphone(395, "Iphone 12 Pro", 87600, "Apple");
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSaveAll() {
        manager.add(book);
        manager.add(phone);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        Product[] actual = manager.findAll();
        Product[] expected = {book, phone, book1, phone1, book2, phone2};

        assertArrayEquals(actual, expected);

    }


    @Test
    public void shouldFindTwoElements() {
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(phone);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);

        Product[] actual = manager.searchBy("one");
        Product[] expected = {book2, phone2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNull() {
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(phone);
        manager.add(book1);

        Product[] actual = manager.searchBy("one");
        Product[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllElements() {
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("The");
        Product[] expected = { book, book1, book2};

        assertArrayEquals(actual, expected);
    }

}
