package com.asiainfo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }


    @RequestMapping("/hello")
    public Map<String, Object> hello(@RequestBody JSONObject reqJSON) {
        System.out.println(reqJSON.toString());

        Map<String, Object> reqMap = JSONObject.toJavaObject(reqJSON, Map.class);
        for (Map.Entry<String, Object> entry : reqMap.entrySet()) {
            reqMap.put(entry.getKey(), entry.getValue() + "123");
        }
        return reqMap;
    }

    @RequestMapping("/world")
    public String world() {
        return "world";
    }
}
