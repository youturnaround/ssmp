package com.zzl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.domain.Book;

import java.util.List;

public interface BookService {

    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    Page<Book> getPage(int current,int size);


}
