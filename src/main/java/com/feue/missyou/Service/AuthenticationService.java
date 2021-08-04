package com.feue.missyou.Service;

import com.feue.missyou.dto.TokenGetDTO;

/**
 * @author Feue
 * @create 2021-07-30 16:25
 */
public interface AuthenticationService {
    void getTokenByEmail(TokenGetDTO dto);

    void validateByWx(TokenGetDTO dto);

    void register();
}
