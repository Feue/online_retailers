package com.feue.missyou.Service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feue.missyou.Service.WxAuthenticationService;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.model.User;
import com.feue.missyou.repository.UserRepository;
import com.feue.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-30 16:58
 */
@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository userRepository;

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;
    @Value("${wx.code2session}")
    private String code2SessionUrl;

    @Override
    public String code2Session(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);
        RestTemplate rest = new RestTemplate();
        String sessionText = rest.getForObject(url, String.class);
        Map<String, Object> session = new HashMap<>();
        try {
            session = mapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
    }

    @Override
    public String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if (openid == null) {
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = this.userRepository.findByOpenid(openid);
        if (userOptional.isPresent()) {
            // TODO: 返回JWT令牌
            return JwtToken.makeToken(userOptional.get().getId());
        }
        User user = User.builder()
                .openid(openid)
                .build();
        userRepository.save(user);
        // TODO: 返回JWT令牌
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }
}
