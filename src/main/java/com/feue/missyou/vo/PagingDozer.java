package com.feue.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feue
 * @create 2021-07-25 13:46
 */
public class PagingDozer<T, K> extends Paging {
    @SuppressWarnings(value = "unchecked")
    public PagingDozer(Page<T> pageT, Class<K> classK) {
        this.initPageParameters(pageT);
        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<>();
        tList.forEach(t -> {
            K vo = mapper.map(t, classK);
            voList.add(vo);
        });
        this.setItems(voList);
    }
}
