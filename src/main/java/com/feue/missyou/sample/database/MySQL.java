package com.feue.missyou.sample.database;

import com.feue.missyou.sample.IConnect;
import org.springframework.stereotype.Component;

/**
 * @author Feue
 * @create 2021-06-20 22:06
 */

public class MySQL implements IConnect {
    private String ip = "localhost";

    private Integer port = 3306;

    public MySQL() {
    }

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println(this.ip+":"+this.port);
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
