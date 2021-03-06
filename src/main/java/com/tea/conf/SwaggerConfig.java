package com.tea.conf;

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
 * @author wenlong
 * @create 2021/7/26 8:12
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo指定测试文档基本信息，这部分将在页面展示
                .apiInfo(apiInfo())
                .select()
                //apis() 控制哪些接口暴露给swagger，
                // RequestHandlerSelectors.any() 所有都暴露
                // RequestHandlerSelectors.basePackage("com.info.*")  指定包位置
                .apis(RequestHandlerSelectors.basePackage("com.tea.cmd"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 基本信息，页面展示
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("tea_api")
                .description("tea_api")
                //联系人实体类
                .contact(
                        new Contact("wenlong", "https://github.com/Imidst/tea_api/tree/master", "midsu_wy@163.com")
                )
                //版本号
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}
