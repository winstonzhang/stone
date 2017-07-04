package com.winston.stone.lottery.service;

import com.winston.stone.lottery.domain.Demo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author winston
 *         2017/7/2/002 20:58
 */
public interface LotteryService {

    Demo findDemo(Long id);

    void save(Demo demo);

    void removeDemo(Long id);
}
