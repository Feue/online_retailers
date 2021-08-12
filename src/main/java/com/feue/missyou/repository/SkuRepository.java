package com.feue.missyou.repository;

import com.feue.missyou.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2021-08-10 10:00
 */
public interface SkuRepository extends JpaRepository<Sku, Long> {
    List<Sku> findAllByIdIn(List<Long> ids);
}
