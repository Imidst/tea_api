package com.tea.conf;

import com.tea.conf.iter.OverallInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wenlong
 * @create 2021/7/26 10:55
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(overallInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public OverallInterceptor overallInterceptor() {
        return new OverallInterceptor();
    }
}