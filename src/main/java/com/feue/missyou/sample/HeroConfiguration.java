package com.feue.missyou.sample;

import com.feue.missyou.sample.condition.DianaCondition;
import com.feue.missyou.sample.condition.IreliaCondition;
import com.feue.missyou.sample.hero.Camille;
import com.feue.missyou.sample.hero.Diana;
import com.feue.missyou.sample.hero.Irelia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Feue
 * @create 2021-06-20 18:19
 */
@Configuration
public class HeroConfiguration {
    @Bean
//    @ConditionalOnProperty(value = "hero.condition", havingValue = "diana", matchIfMissing = true)
//    @Conditional(DianaCondition.class)
    public ISkill diana() {
        return new Diana("diana", 18);
    }

//    @Bean
//    @ConditionalOnProperty(value = "hero.condition", havingValue = "irelia")
//    @Conditional(IreliaCondition.class)
    public ISkill irelia() {
        return new Irelia();
    }
}
