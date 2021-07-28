package com.feue.missyou.vo;

import com.feue.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @author Feue
 * @create 2021-07-28 13:55
 */
@Getter
@Setter
public class CategoryPureVO {
    private Long id;
    private String name;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
