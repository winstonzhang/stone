package com.winston.stone.lottery.controller;

import com.winston.stone.lottery.domain.Demo;
import com.winston.stone.lottery.service.LotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author winston
 *         2017/6/17/017 20:06
 */
@RestController
@Api(value = "demo服务")
public class DemoController extends BaseController {

    private static final Logger log = LogManager.getLogger();

    @Resource
    private LotteryService lotteryService;

    @ApiOperation(value = "查询demo", notes = "根据ID查询")
    @ApiImplicitParam(name = "id", value = "demo的id", paramType = "path", required = true, dataType = "Long")
    @GetMapping("/demo/{id}")
    public String findById(@PathVariable(value = "id") Long id) {
        Demo demo = lotteryService.findDemo(id);

        if (demo == null) {
            return "error";
        } else {
            return "name:" + demo.getName() + " , age:" + demo.getAge();
        }

    }

    @DeleteMapping("demo/{id}")
    public String removeById(@PathVariable(value = "id") Long id) {
        lotteryService.removeDemo(id);
        return "";
    }

    @PostMapping("/demo")
    public String save(@RequestBody Demo demo) {
        lotteryService.save(demo);
        return "";
    }
}
