package com.winston.stone.lottery.service.impl;

import com.winston.stone.lottery.domain.Demo;
import com.winston.stone.lottery.repository.DemoRepository;
import com.winston.stone.lottery.service.LotteryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author winston
 *         2017/7/2/002 21:33
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    @Resource
    private DemoRepository demoRepository;

    @Override
    @Cacheable(value = "demo", key = "#id")
    public Demo findDemo(Long id) {
        return demoRepository.findById(id);
    }

    @Override
    public void save(Demo demo) {
        demoRepository.save(demo);
    }

    @Override
    @CacheEvict(value = "demo", key = "#id")
    public void removeDemo(Long id) {
        demoRepository.delete(id);
    }
}
