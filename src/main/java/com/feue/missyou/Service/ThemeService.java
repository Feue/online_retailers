package com.feue.missyou.Service;

import com.feue.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-28 15:07
 */
public interface ThemeService {
    List<Theme> findByNames(List<String> names);

    Optional<Theme> findByName(String name);
}
