package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.SkuService;
import com.feue.missyou.model.Sku;
import com.feue.missyou.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Feue
 * @create 2021-08-10 9:59
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuRepository skuRepository;

    @Override
    public List<Sku> getSkuListByIds(List<Long> ids) {
        return this.skuRepository.findAllByIdIn(ids);
    }
}
