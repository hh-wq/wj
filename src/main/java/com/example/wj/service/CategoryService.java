package com.example.wj.service;

import com.example.wj.dao.CategoryDAO;
import com.example.wj.pojo.Category;
import com.example.wj.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CategoryServiceImpl {
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    @Override
    public Category get(int id) {
        Category c = categoryDAO.findById(id).orElse(null);
        return c;
    }
}
