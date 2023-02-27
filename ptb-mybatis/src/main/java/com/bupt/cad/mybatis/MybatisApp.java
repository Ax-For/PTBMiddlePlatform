package com.bupt.cad.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dongyafei
 * @description
 * @date 2023/2/6/006
 */

@SpringBootApplication
@MapperScan("com.bupt.cad.mybatis.mapper")
public class MybatisApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class, args);

    }
}
