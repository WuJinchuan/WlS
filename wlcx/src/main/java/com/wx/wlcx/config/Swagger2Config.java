package com.wx.wlcx.config;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo for test")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(regex("/api/.*"))//过滤的接口
                .build()
                .apiInfo(testApiInfo());
    }

    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths((regex("/demo/.*")))//过滤的接口
                .build()
                .apiInfo(demoApiInfo());
    }

    private ApiInfo testApiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot 集成 Swagger2")//大标题
                .description("Rest api document")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("Glen", "https://blog.csdn.net/qq_35623773", "18397641397@163.com"))//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    private ApiInfo demoApiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot 集成 Swagger2")//大标题
                .description("Rest api document")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("Glen", "https://blog.csdn.net/qq_35623773", "18397641397@163.com"))//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Bean
    public Docket OnlyRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                // 排除特定类
                if (declaringClass == BasicErrorController.class)
                    return false;
                // 包含特定的类
                if(declaringClass.isAnnotationPresent(RestController.class))
                    return true;
                // 包含特定注解的方法
                if(input.isAnnotatedWith(GetMapping.class) || input.isAnnotatedWith(PostMapping.class))
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(restApiInfo())
                .groupName("Only rest api.")
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
    }

    private ApiInfo restApiInfo() {
        return new ApiInfoBuilder()
                .title("Only include rest api.")//大标题
                .version("1.0")//版本
                .build();
    }
}
