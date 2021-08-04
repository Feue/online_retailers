package com.feue.missyou.api.v1;

import com.feue.missyou.Service.BannerService;
import com.feue.missyou.core.interceptors.ScopeLevel;
import com.feue.missyou.dto.PersonDTO;
import com.feue.missyou.exception.http.ForbiddenException;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.model.Banner;
import com.feue.missyou.sample.IConnect;
import com.feue.missyou.sample.ISkill;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * @author Feue
 * @create 2021-06-04 16:28
 */
//@Lazy // 延迟加载标记
@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    @ScopeLevel
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }
} 