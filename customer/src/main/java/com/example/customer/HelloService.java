package com.example.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: WZW
 * @date 2020/5/18 15:29
 * @Description: TODO
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法111111
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        String str1 = restTemplate.getForObject("http://service-provider/hi?name=" + name, String.class);
        return str1;
    }

    public String hiError(String name) {
        return "hey " + name + ", there is some problem with hi page";
    }

}
