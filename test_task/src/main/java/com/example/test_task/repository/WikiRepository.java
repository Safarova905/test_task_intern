package com.example.test_task.repository;

import com.example.test_task.models.WikiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends JpaRepository<WikiModel, Integer>{
    WikiModel findByTitle(String title);
}
