package com.feue.missyou.vo;

import com.feue.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-07-28 12:50
 */
@Getter
@Setter
public class CategoriesAllVO {
    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;

    public CategoriesAllVO(Map<String, List<Category>> categories) {
//        List<Category> roots = categories.get("roots");
//        roots.forEach(category -> {
//            CategoryPureVO vo = new CategoryPureVO(category);
//            this.roots.add(vo);
//        });
        this.roots = categories.get("roots").stream()
                .map(CategoryPureVO::new)
                .collect(Collectors.toList());
        this.subs = categories.get("subs").stream()
                .map(CategoryPureVO::new)
                .collect(Collectors.toList());
    }
}
