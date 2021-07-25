package com.feue.missyou.Service;

/**
 * @author Feue
 * @create 2021-07-19 15:00
 */

import com.feue.missyou.model.Banner;
import com.feue.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
