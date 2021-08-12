package com.feue.missyou.api.v1;

import com.feue.missyou.core.LocalUser;
import com.feue.missyou.core.interceptors.ScopeLevel;
import com.feue.missyou.dto.OrderDTO;
import com.feue.missyou.vo.OrderIdVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feue
 * @create 2021-08-10 9:13
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @ScopeLevel
    @PostMapping
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO) {
        Long uid = LocalUser.getUser().getId();
        return null;
    }
}
