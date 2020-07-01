package com.lwy.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwy
 * @Title: DemoController
 * @Package com.lwy.nacoseprovider.controller
 * @Description: 提供服务接口
 * @date 2020/6/3010:33
 */
@RestController
public class DemoController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/demo")
    public String demo(String name){
        return "Hello:"+name+port;
    }
}
