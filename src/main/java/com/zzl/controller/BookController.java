package com.zzl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.controller.utils.R;
import com.zzl.domain.Book;
import com.zzl.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

//    @GetMapping
//    public List<Book> getAll() {
//        return bookService.list();
//    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) throw new IOException();
        return new R(true,bookService.save(book));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {

        return new R(true,bookService.getById(id));
    }

//    @GetMapping("{curr}/{size}")
//    public R getAll(@PathVariable int curr,@PathVariable int size) {
//        Page<Book> page = bookService.getPage(curr, size);
//        //如果当前页码值 大于了总页码值  使用最大页码值作为当前页
//        if (curr > page.getPages()) {
//            page = bookService.getPage((int)page.getPages(),size);
//        }
//        return new R(null != page,page);
//    }
    @GetMapping("{curr}/{size}")
    public R getAll(@PathVariable int curr,@PathVariable int size,Book book) {
        Page<Book> page = bookService.getPage(curr, size,book);
        //如果当前页码值 大于了总页码值  使用最大页码值作为当前页
        if (curr > page.getPages()) {
            page = bookService.getPage((int)page.getPages(),size,book);
        }
        return new R(null != page,page);
    }

    @DeleteMapping("{id}")
    public R deleteBook(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new R(flag,null);
    }

     @PutMapping
     public R updateBook(@RequestBody Book book ) {
        return new R(bookService.updateById(book));
    }
}
