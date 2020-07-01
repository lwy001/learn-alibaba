package com.lwy.nacos.config.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lwy
 * @Title: com.lwy.nacosconsumer
 * @Package DemoFeignService
 * @Description: Feign 代理服务
 * @date 2020/6/3013:43
 */
@FeignClient("nacos-provider")
public interface DemoFeignService {

    @GetMapping("/demo")
    String demo(@RequestParam String name);
}
