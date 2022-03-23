package com.zzl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.domain.Book;

public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean delete(Integer id);

    Page<Book> getPage(int curr, int size);
    Page<Book> getPage(int curr, int size, Book book);

    boolean modify(Book book);
}
