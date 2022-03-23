package com.zzl.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao dao;
    @Override
    public boolean saveBook(Book book) {
        return dao.insert(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return dao.deleteById(id) > 0;
    }

    @Override
    public Page<Book> getPage(int curr, int size) {
        Page<Book> page = new Page<>(curr,size);
        dao.selectPage(page,null);
        return page;
    }


    @Override
    public Page<Book> getPage(int curr, int size, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper();

        wrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        Page<Book> page = new Page<>(curr,size);
        dao.selectPage(page,wrapper);
        return page;
    }

    @Override
    public boolean modify(Book book) {
        return  dao.updateById(book) > 0;
    }


}
