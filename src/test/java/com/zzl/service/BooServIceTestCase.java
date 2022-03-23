package com.zzl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BooServIceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(3));
    }

    @Test
    void getPage() {
        Page<Book> page = bookService.getPage(2, 5);
        List<Book> records = page.getRecords();
        for (Book record : records) {
            System.out.println(record);
        }
    }
}
