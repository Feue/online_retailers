package com.feue.missyou.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Feue
 * @create 2021-07-26 10:34
 */
@Getter
@Setter
public class Spec implements Serializable {
    private String key;
    private String value;
    @JsonProperty("key_id")
    private Long keyId;
    @JsonProperty("value_id")
    private Long valueId;
}
