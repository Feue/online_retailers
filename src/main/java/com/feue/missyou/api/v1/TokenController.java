package com.feue.missyou.api.v1;

import com.feue.missyou.Service.WxAuthenticationService;
import com.feue.missyou.dto.TokenDTO;
import com.feue.missyou.dto.TokenGetDTO;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-07-30 15:33
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO dto) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (dto.getLoginType()) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(dto.getAccount());
                break;
            case USER_EMAIL:
                break;
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody TokenDTO token) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean valid = JwtToken.verifyToken(token.getToken());
        map.put("is_valid", valid);
        return map;
    }
}
