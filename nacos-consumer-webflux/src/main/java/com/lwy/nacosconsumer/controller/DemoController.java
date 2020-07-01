package com.lwy.nacosconsumer.controller;

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
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
    private WebClient.Builder webClientBuilder;
    @GetMapping("/test3")
    public Mono<String> test(@RequestParam String name){

        WebClient build = webClientBuilder.build();
        String uri = "http://nacos-provider/demo?name="+name;
        Mono<String> mono = build.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }
}
