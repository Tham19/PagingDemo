package com.github.thamvannguyen.manager;

import com.github.thamvannguyen.entity.Category;

import java.util.List;

/**
 * Created by tham on 6/7/17.
 */
public interface CategoryManagerEntity {
    Category findById(String id);
    void save(Category category);
    List<Category> getAll();
}
