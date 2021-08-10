package com.feue.missyou.api.v1;

import com.feue.missyou.Service.ActivityService;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.model.Activity;
import com.feue.missyou.vo.ActivityCouponVO;
import com.feue.missyou.vo.ActivityPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feue
 * @create 2021-08-06 14:48
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/name/{name}")
    public ActivityPureVO getHomeActivity(@PathVariable String name) {
        Activity activity = this.activityService.getByName(name);
        if (activity == null) {
            throw new NotFoundException(40001);
        }
        return new ActivityPureVO(activity);
    }

    @GetMapping("/name/{name}/with_coupon")
    public ActivityCouponVO getActivityWithCoupons(@PathVariable String name) {
        Activity activity = this.activityService.getByName(name);
        if (activity == null) {
            throw new NotFoundException(40001);
        }
        return new ActivityCouponVO(activity);
    }
}
