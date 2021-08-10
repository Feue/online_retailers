package com.feue.missyou.repository;

import com.feue.missyou.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Feue
 * @create 2021-08-06 14:49
 */
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity getOneByName(String name);
    Optional<Activity> findByCouponListId(Long couponId);
}
