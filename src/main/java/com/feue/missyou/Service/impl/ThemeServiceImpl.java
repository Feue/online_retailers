package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.ThemeService;
import com.feue.missyou.model.Theme;
import com.feue.missyou.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-28 15:07
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> findByNames(List<String> names) {
        return this.themeRepository.findByNames(names);
    }

    @Override
    public Optional<Theme> findByName(String name) {
        return this.themeRepository.findByName(name);
    }
}
