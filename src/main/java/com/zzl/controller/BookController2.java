package com.zzl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.domain.Book;
import com.zzl.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping("/getAll")
    public List<Book> getAll() {
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{curr}/{size}")
    public Page<Book> getPage(@PathVariable int curr,@PathVariable int size) {
        Page<Book> page = bookService.getPage(curr, size, null);
        return page;
    }
}
