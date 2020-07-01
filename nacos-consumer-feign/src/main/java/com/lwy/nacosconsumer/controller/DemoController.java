package com.lwy.nacosconsumer.controller;

import com.lwy.nacosconsumer.service.DemoFeignService;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

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
