package com.feue.missyou.sample;

import com.feue.missyou.sample.database.MySQL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Feue
 * @create 2021-06-20 22:07
 */
@Configuration
public class DBConfiguration {
//    @Value("${mysql.ip}")
    private String ip;
//    @Value("${mysql.port}")
    private Integer port;

    @Bean
    public IConnect mysql() {
        return new MySQL(this.ip, this.port);
    }
}
