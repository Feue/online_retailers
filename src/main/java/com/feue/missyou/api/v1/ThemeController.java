package com.feue.missyou.api.v1;

import com.feue.missyou.Service.ThemeService;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.model.Theme;
import com.feue.missyou.vo.ThemePureVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-23 14:36
 */
@RestController
@RequestMapping("/theme")
@Validated
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(@RequestParam(name = "names") @NotBlank String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themeList = this.themeService.findByNames(nameList);
        List<ThemePureVO> voList = new ArrayList<>();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        themeList.forEach(theme -> {
            ThemePureVO vo = mapper.map(theme, ThemePureVO.class);
            voList.add(vo);
        });
        return voList;
    }

    @GetMapping("/name/{name}/with_spu")
    public Theme getThemeByNameWithSpu(@PathVariable @NotBlank String name) {
        Optional<Theme> optionalTheme = this.themeService.findByName(name);
        return optionalTheme.orElseThrow(() -> new NotFoundException(30003));
    }
}
