package com.springboot.quickstrat.dao;

import com.springboot.quickstrat.entity.Book;
import org.springframework.stereotype.Component;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书的DAO类
 */
@Component
public class BookDAO {
    public List<Book>getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "spring boot", 88.8));
        books.add(new Book(2, "spring ", 88.8));
        books.add(new Book(3, "spring boot", 88.8));
        return books;
    }
}
