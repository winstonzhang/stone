package com.winston.stone.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author winston
 *         2017/6/17/017 17:20
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class LotteryApplication {

    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");

        SpringApplication.run(LotteryApplication.class, args);
    }
}
