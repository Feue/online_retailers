package com.feue.missyou.repository;

import com.feue.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-07-23 16:13
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(Long id);

    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long cid, Pageable pageable);
    // select * from spu where category_id = cid
    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long cid, Pageable pageable);
}
