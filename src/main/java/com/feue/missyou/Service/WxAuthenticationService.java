package com.feue.missyou.Service;

import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-30 16:58
 */
public interface WxAuthenticationService {
    String code2Session(String code);

    String registerUser(Map<String, Object> session);
}
