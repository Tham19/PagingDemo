package com.github.thamvannguyen.repository;

import com.github.thamvannguyen.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tham on 6/7/17.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
