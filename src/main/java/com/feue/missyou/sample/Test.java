package com.feue.missyou.sample;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Feue
 * @create 2021-08-10 12:55
 */
@Component
@Getter
@Setter
@Scope("prototype")
public class Test {
    private String name = "Feue";
}
