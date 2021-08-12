package com.feue.missyou.Service;

import com.feue.missyou.model.Sku;

import java.util.List;

/**
 * @author Feue
 * @create 2021-08-10 9:59
 */
public interface SkuService {
    List<Sku> getSkuListByIds(List<Long> ids);
}
