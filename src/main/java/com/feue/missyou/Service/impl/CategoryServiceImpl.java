package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.CategoryService;
import com.feue.missyou.model.Category;
import com.feue.missyou.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-28 13:03
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Map<String, List<Category>> getAll() {
        List<Category> roots = this.categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = this.categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        Map<String, List<Category>> categories = new HashMap<>();
        categories.put("roots", roots);
        categories.put("subs", subs);
        return categories;
    }
}
