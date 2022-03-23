package com.zzl.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        bookDao.insert(book);
    }


    @Test
    void testDelete() {
        bookDao.deleteById(13);
    }

    @Test
    void testGetAll() {
        List<Book> books = bookDao.selectList(null);
        for (Book book : books) {
            System.out.println(book);

        }


    }

    @Test
    void testGePage() {
        Page page = new Page(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());

    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setName("xixixi");
        book.setType("测试数据");
        book.setDescription("测试数据");
        bookDao.updateById(book);
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name","Spring");
        bookDao.selectList(wrapper);
    }

}
