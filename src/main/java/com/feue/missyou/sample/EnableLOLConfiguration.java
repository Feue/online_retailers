package com.feue.missyou.sample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Feue
 * @create 2021-07-15 17:43
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LOLConfigurationSelector.class)
public @interface EnableLOLConfiguration {
}
