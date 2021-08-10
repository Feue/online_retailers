package com.feue.missyou.repository;

import com.feue.missyou.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Feue
 * @create 2021-08-04 13:40
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOpenid(String openid);
    User findOneById(Long id);
}
