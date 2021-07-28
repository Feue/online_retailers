package com.feue.missyou.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.feue.missyou.util.GenericAndJson;
import com.feue.missyou.util.ListAndJson;
import com.feue.missyou.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-23 17:11
 */
@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online = 1")
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    private Long categoryId;
    private Long rootCategoryId;

//    @Convert(converter = ListAndJson.class)
//    private List<Object> specs;
    private String specs;
    private String code;
    private Long stock;

    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.EMPTY_LIST;
        }
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {
        });
//        return GenericAndJson.jsonToList(this.specs);
    }

    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
//    @Convert(converter = MapAndJson.class)
//    private Map<String, Object> test;
}
