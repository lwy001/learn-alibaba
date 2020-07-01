package com.lwy.nacos.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwy
 * @Title: com.lwy.nacoa.config.client.controller
 * @Package DemoController
 * @Description: 测试nacos配置
 * @date 2020/7/117:19
 */
@RefreshScope
@RestController
public class DemoController {
    @Value("${test:123}")
    private String name;

    @GetMapping("/test")
    public String test(){
        return "name:"+name;
    }
}
