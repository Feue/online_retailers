package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.ActivityService;
import com.feue.missyou.model.Activity;
import com.feue.missyou.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feue
 * @create 2021-08-06 14:50
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getByName(String name) {
        return this.activityRepository.getOneByName(name);
    }
}
