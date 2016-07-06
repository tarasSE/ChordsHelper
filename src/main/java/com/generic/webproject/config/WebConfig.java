package com.generic.webproject.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.generic.webproject.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    protected final static String ACTIVE_PROFILES = "spring.active-profiles";

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    @Bean
    public Mapper beanMapper() {
        return new DozerBeanMapper();
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Configuration
    public static class SpittrWebAppInitiaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class<?>[]{RootConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[]{WebConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/*"};
        }

        @Override
        protected WebApplicationContext createRootApplicationContext() {

            WebApplicationContext context =
                    (WebApplicationContext) super.createRootApplicationContext();

            ((ConfigurableEnvironment) context.getEnvironment())
                    .setActiveProfiles(getActiveProfiles());

            return context;
        }

        protected String[] getActiveProfiles() {
            String profiles = getProperties().getProperty(ACTIVE_PROFILES);

            if (profiles.contains(",")) {
                return profiles.split(",");
            }

            return new String[]{profiles};
        }

        private Properties getProperties(){
            Properties properties = new Properties();

            try (InputStream is = getClass().getResourceAsStream("/application.properties")){
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return properties;
        }
    }
}
