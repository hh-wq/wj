package com.example.wj.service.Impl;

import com.example.wj.pojo.Book;

import java.util.List;

public interface BookServiceImpl {
    List<Book> list();
    void addOrUpdate(Book book);
    void deleteById(int id);
    List<Book> listByCategory(int cid);
    List<Book> Search(String keywords);
}
