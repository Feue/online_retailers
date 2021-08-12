package com.feue.missyou.repository;

import com.feue.missyou.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-08-12 15:21
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
