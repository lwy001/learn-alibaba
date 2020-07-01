package com.lwy.nacos.config.client.controller;

import com.lwy.nacos.config.client.service.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwy
 * @Title: com.lwy.nacosconsumer
 * @Package DemoController
 * @Description: 消费服务接口
 * @date 2020/6/3010:36
 */
@RestController
public class DemoController {

    @Autowired
    private DemoFeignService demoFeignService;
    @GetMapping("/demo")
    public String demo(String name){

        String str = demoFeignService.demo(name);
        return str;
    }
}
