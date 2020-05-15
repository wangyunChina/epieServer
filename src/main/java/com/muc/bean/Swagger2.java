package com.muc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 本文件由周涛创建,位于com.tao.mybatis_plus.config包下
 * 创建时间2018/3/24 19:04
 * 邮箱:zhoutao@xiaodouwangluo.com
 * 作用:暂未填写
 *
 * @author tao
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //设置扫描的包名
                .apis(RequestHandlerSelectors.basePackage("com.muc.action"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文档内容配置信息
                .title("SpringBoot整合Swagger")
                .description("这是一个简单的SpringBoot项目，基于Maven架构，SSM框架搭建")
                .termsOfServiceUrl("https://www.zhoutao123.com")
                .version("1.0")
                .build();
    }
}
