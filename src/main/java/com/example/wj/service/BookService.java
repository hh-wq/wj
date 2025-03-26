package com.example.wj.service;

import com.example.wj.dao.BookDAO;

import com.example.wj.pojo.Book;
import com.example.wj.pojo.Category;
import com.example.wj.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService implements BookServiceImpl {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Book> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    @Override
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    @Override
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    @Override
    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%','%' + keywords + '%');
    }
}
