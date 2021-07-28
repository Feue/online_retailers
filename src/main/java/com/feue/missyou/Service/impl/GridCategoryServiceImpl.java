package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.GridCategoryService;
import com.feue.missyou.model.GridCategory;
import com.feue.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Feue
 * @create 2021-07-28 14:32
 */
@Service
public class GridCategoryServiceImpl implements GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    @Override
    public List<GridCategory> getGridCategoryList() {
        return this.gridCategoryRepository.findAll();
    }
}
