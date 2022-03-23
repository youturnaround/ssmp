package com.zzl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BooServIceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(3));
    }

    @Test
    void testGetAll() {
        List<Book> list = bookService.list();
        System.out.println(list);
    }
}
