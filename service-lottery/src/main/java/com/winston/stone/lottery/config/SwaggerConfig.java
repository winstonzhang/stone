package com.winston.stone.lottery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author winston
 *         2017/6/19/019 21:37
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Stone services").genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false)
                .forCodeGeneration(false).pathMapping("/").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.winston.stone.lottery.controller")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Stone").description("winston's first framework").termsOfServiceUrl("")
                .contact(new Contact("winston", "", "winston@xxx.com")).version("1.0").build();
    }
}
