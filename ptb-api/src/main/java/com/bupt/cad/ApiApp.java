package com.bupt.cad;

import com.alibaba.fastjson.JSONArray;
import com.bupt.cad.service.FunnyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author dongyafei
 * @description
 * @date 2023/2/4/004
 */

@SpringBootApplication
public class ApiApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApiApp.class, args);
        FunnyService funnyService = applicationContext.getBean(FunnyService.class);
        JSONArray jsonArray = funnyService.wantWords("天气很冷");
        System.out.println("jsonArray = " + jsonArray);
    }
}
