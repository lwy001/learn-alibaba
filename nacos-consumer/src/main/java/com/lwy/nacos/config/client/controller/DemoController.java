package com.lwy.nacos.config.client.controller;

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
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/test")
    public String test(@RequestParam String name){

//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
//        URI uri = serviceInstance.getUri();
//        String url = uri+"/demo?name="+name;
//        System.out.println("url:"+url);
//        String str = restTemplate.getForObject(url, String.class);
//        String str = restTemplate.getForObject("http://nacos-provider/demo?name="+name, String.class);


        RibbonLoadBalancerClient.RibbonServer ribbonServer = (RibbonLoadBalancerClient.RibbonServer)loadBalancerClient.choose("nacos-provider");
        NacosServer server = (NacosServer)ribbonServer.getServer();
        String host = server.getHost();
        int port = server.getPort();
        Map<String, String> metadata = server.getMetadata();
        System.out.println("metadata:"+metadata);
        String url = "http://" + host + ":" + port + "/demo?name=" + name;
        System.out.println("url:"+url);
        String str = restTemplate.getForObject(url, String.class);

        return str;
    }
}
