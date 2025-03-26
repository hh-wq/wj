package com.example.wj.service.Impl;

import com.example.wj.pojo.Category;

import java.util.List;

public interface CategoryServiceImpl {
    List<Category> list();
    Category get(int id);
}
