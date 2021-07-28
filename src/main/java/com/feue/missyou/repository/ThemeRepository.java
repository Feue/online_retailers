package com.feue.missyou.repository;

import com.feue.missyou.model.Theme;
import com.feue.missyou.vo.ThemePureVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-28 15:06
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    @Query("select t from Theme t where t.name in (:names)")
    List<Theme> findByNames(List<String> names);

    Optional<Theme> findByName(String name);
}
