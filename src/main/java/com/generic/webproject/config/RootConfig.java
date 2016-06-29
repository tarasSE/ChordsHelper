package com.generic.webproject.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.generic.webproject"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@Import(WebConfig.class)
public class RootConfig {
        @Bean
        public Mapper beanMapper() {
            return new DozerBeanMapper();
        }
}
