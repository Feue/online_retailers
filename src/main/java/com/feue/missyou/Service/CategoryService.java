package com.feue.missyou.Service;

import com.feue.missyou.model.Category;

import java.util.List;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-28 13:03
 */
public interface CategoryService {
    public Map<String, List<Category>> getAll();
}
