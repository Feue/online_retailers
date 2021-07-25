package com.feue.missyou.repository;

import com.feue.missyou.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-07-23 16:13
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(Long id);
}
