package com.bupt.cad.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

/**
 * @author dongyafei
 * @description
 * @date 2023/2/6/006
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisCodeGenerator {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Test
    public void testVariables() {
        String modulePath = System.getProperty("user.dir");
        FastAutoGenerator.create(dataSourceProperties.getUrl(), dataSourceProperties.getUsername(), dataSourceProperties.getPassword())
                .globalConfig(builder -> {
                    builder
                            .author("cad")
                            .dateType(DateType.TIME_PACK)
                            .fileOverride()
                            .disableOpenDir()
                            .outputDir(modulePath + "/src/main/java")
                    ;
                })
                .packageConfig(builder -> {
                    builder
                            .parent("com.bupt.cad")
                            .moduleName("mybatis")
                            .entity("domain")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, modulePath + "/src/main/resources/mapper"))
                    ;
                })
                .strategyConfig(builder -> {
                    builder
                            .enableCapitalMode()
                            .addInclude("record", "user")

                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableFileOverride()

                            .mapperBuilder()
                            .enableFileOverride()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
