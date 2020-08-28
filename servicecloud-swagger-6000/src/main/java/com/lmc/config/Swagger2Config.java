package com.lmc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author lmc
 * @Description
 * @Date: Create in 22:05 2020/8/24
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 配置扫描接口
     * @return
     */
    @Bean
    public Docket createRestApi() {
        //设置要显示的swagger环境
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//配置Swagger信息
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //RequestHandlerSelectors.basePackage指定要扫描的包
                //any()扫描全部
                //none()全部不扫描
                //withMethodAnnotation:扫描方法上的注解
                //withClassAnnotation:扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.lmc.controller"))
                //paths 过滤什么路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Lmc TEST")
                .description("Lmc TEST Restful API")
                .contact(new Contact("lmc", "", "limincong@163.com"))
                .termsOfServiceUrl("http://localhost:6000/")
                .version("1.0")
                .build();
    }
}
