package com.feue.missyou;

import com.feue.missyou.sample.EnableLOLConfiguration;
import com.feue.missyou.sample.HeroConfiguration;
import com.feue.missyou.sample.ISkill;
import com.feue.missyou.sample.LOLConfigurationSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author Feue
 * @create 2021-07-15 17:01
 */
//@ComponentScan
//@Import(LOLConfigurationSelector.class)
@EnableLOLConfiguration
public class LOLApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(LOLApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        ISkill iSkill = (ISkill) context.getBean("irelia");
        iSkill.r();
    }
}
