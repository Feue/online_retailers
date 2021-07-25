package com.feue.missyou.Service;

import com.feue.missyou.model.Spu;
import com.feue.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Feue
 * @create 2021-07-23 16:12
 */
@Service
public class SpuServiceImpl implements SpuService{
    @Autowired
    SpuRepository spuRepository;

    @Override
    public Spu getSpuById(Long id) {
        return spuRepository.findOneById(id);
    }

    @Override
    public Page<Spu> getLatestPagingSpu(Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }
}
