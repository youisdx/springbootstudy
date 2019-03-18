package com.springboot.quickstrat.controller;

import com.springboot.quickstrat.dao.BookDAO;
import com.springboot.quickstrat.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
    @Resource
    private BookDAO bookDAO;
    @RequestMapping(value="/books" ,method= RequestMethod.GET)
    public List<Book> getBooks(){
        return bookDAO.getBooks();
    }
}
