package com.github.thamvannguyen.managerImpl;

import com.github.thamvannguyen.entity.Category;
import com.github.thamvannguyen.manager.CategoryManagerEntity;
import com.github.thamvannguyen.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tham on 6/7/17.
 */
@Service
public class CategoryManagerImpl implements CategoryManagerEntity {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(String id) {
        return categoryRepository.findOne(id);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
