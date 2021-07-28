package com.feue.missyou.Service;

import com.feue.missyou.model.Spu;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Feue
 * @create 2021-07-23 16:12
 */
public interface SpuService {
    Spu getSpuById(Long id);

    Page<Spu> getLatestPagingSpu(Integer pageNumber, Integer size);

    Page<Spu> getByCategoryId(Long id, Boolean isRoot, Integer pageNumber, Integer size);
}
