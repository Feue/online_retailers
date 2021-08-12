package com.feue.missyou.Service;

import com.feue.missyou.dto.OrderDTO;
import com.feue.missyou.logic.CouponChecker;
import com.feue.missyou.logic.OrderChecker;

/**
 * @author Feue
 * @create 2021-08-10 9:51
 */
public interface OrderService {
    OrderChecker isOk(Long uid, OrderDTO orderDTO);
    Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker);
}
