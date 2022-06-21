package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product book = new Book(765, "The Assassination Bureau", 1750, "Jack London");
    Product phone = new Smartphone(12, "Redmi Note 11S", 26700, "Xiaomi");
    Product book1 = new Book(133, "The Road with No Return", 750, "Andrzej Sapkowski");
    Product phone1 = new Smartphone(6897, "Galaxy A32", 26000, "Samsung");
    Product book2 = new Book(6, "The Stone Guest", 380, "Alexander Pushkin");
    Product phone2 = new Smartphone(395, "Iphone 12 Pro", 87600, "Apple");


    @Test
    public void shouldSaveAll() {
        repo.save(book);
        repo.save(phone);
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);

        Product[] actual = repo.findAll();
        Product[] execution = {book, phone, book1, phone1, book2, phone2};
        assertArrayEquals(actual, execution);
    }

    @Test
    public void shouldRemoveOneElement() {
        repo.save(book);
        repo.save(phone);
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);

        repo.removeById(6897);
        Product[] actual = repo.findAll();
        Product[] execution = {book, phone, book1, book2, phone2};
        assertArrayEquals(actual, execution);
    }

    @Test
    public void shouldRemoveNull() {
        repo.save(book);
        repo.save(phone);
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(68);
        });

    }
}
