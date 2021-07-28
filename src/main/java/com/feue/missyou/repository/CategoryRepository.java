package com.feue.missyou.repository;

import com.feue.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2021-07-28 12:52
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // {List,List,List}
    // List,List
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
