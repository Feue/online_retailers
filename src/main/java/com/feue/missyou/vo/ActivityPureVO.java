package com.feue.missyou.vo;

import com.feue.missyou.model.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author Feue
 * @create 2021-08-06 14:51
 */
@Getter
@Setter
@NoArgsConstructor
public class ActivityPureVO {
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String remark;
    private Boolean online;
    private String entranceImg;

    public ActivityPureVO(Activity activity) {
        BeanUtils.copyProperties(activity, this);
    }
}
