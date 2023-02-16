package com.example.test_task.repository;

import com.example.test_task.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategory(String category);
}
