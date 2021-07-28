package com.feue.missyou.api.v1;

import com.feue.missyou.Service.CategoryService;
import com.feue.missyou.Service.GridCategoryService;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.model.Category;
import com.feue.missyou.model.GridCategory;
import com.feue.missyou.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-28 12:39
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("/all")
    public CategoriesAllVO getALL() {
        Map<String, List<Category>> categories = this.categoryService.getAll();
        return new CategoriesAllVO(categories);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList() {
        List<GridCategory> gridCategoryList = this.gridCategoryService.getGridCategoryList();
        if (gridCategoryList.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategoryList;
    }
}
