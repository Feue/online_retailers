package com.feue.missyou.api.v1;

import com.feue.missyou.Service.SpuService;
import com.feue.missyou.bo.PageCounter;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.model.Spu;
import com.feue.missyou.util.CommonUtil;
import com.feue.missyou.vo.Paging;
import com.feue.missyou.vo.PagingDozer;
import com.feue.missyou.vo.SpuSimplifyVO;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feue
 * @create 2021-06-04 16:28
 */
//@Lazy // 延迟加载标记
@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = this.spuService.getSpuById(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO getSimplify(@PathVariable @Positive Long id) {
        Spu spu = this.spuService.getSpuById(id);
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu, vo);
        return vo;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                                            @RequestParam(defaultValue = "10") @Positive Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<Spu, SpuSimplifyVO>(page, SpuSimplifyVO.class);
    }
} 