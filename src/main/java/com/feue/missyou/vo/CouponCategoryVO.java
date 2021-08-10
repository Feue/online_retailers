package com.feue.missyou.vo;

import com.feue.missyou.model.Category;
import com.feue.missyou.model.Coupon;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feue
 * @create 2021-08-09 17:13
 */
@Getter
@Setter
public class CouponCategoryVO extends CouponPureVO{
    private List<CategoryPureVO> categories = new ArrayList<>();

    public CouponCategoryVO(Coupon coupon) {
        super(coupon);
        List<Category> categoryList = coupon.getCategoryList();
        categoryList.forEach(category -> {
            CategoryPureVO vo = new CategoryPureVO(category);
            this.categories.add(vo);
        });
    }
}
