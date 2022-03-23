package com.zzl.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public Page<Book> getPage(int current, int size) {
        Page page = new Page(current,size);
        return bookDao.selectPage(page,null);
    }
}
