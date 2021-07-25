package com.feue.missyou.repository;

import com.feue.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Feue
 * @create 2021-07-21 12:15
 */
//@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    Banner findOneById(Long id);
    Banner findOneByName(String name);
}
