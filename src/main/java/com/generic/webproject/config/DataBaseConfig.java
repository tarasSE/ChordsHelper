package com.generic.webproject.config;


import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

//@Profile("dev")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.generic.webproject.repository")
@PropertySource(value = "classpath:application.properties")
public class DataBaseConfig {

    private static final String
            PROP_DATABASE_DRIVER = "db.driver";
    private static final String
            PROP_DATABASE_PASSWORD = "db.password";
    private static final String
            PROP_DATABASE_URL = "db.url";
    private static final String
            PROP_DATABASE_USERNAME = "db.username";
    private static final String
            PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String
            PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String
            PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    private static final String
            PROP_HIBERNATE_PACKAGES_TO_SCAN = "db.ent_manager.packages_to_scan";

    @Resource
    private Environment env;

    @Bean
    public AbstractEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        entityManagerFactoryBean.setPackagesToScan(
                env.getRequiredProperty(PROP_HIBERNATE_PACKAGES_TO_SCAN));

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DriverManagerDataSource();

        ((DriverManagerDataSource) dataSource)
                .setDriverClassName(
                        env.getRequiredProperty(PROP_DATABASE_DRIVER));
        ((DriverManagerDataSource) dataSource)
                .setUrl(
                        env.getRequiredProperty(PROP_DATABASE_URL));
        ((DriverManagerDataSource) dataSource)
                .setUsername(
                        env.getRequiredProperty(PROP_DATABASE_USERNAME));
        ((DriverManagerDataSource) dataSource)
                .setPassword(
                        env.getRequiredProperty(PROP_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public AbstractAdvisingBeanPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(
                "hibernate.dialect",
                env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(
                "hibernate.connection.url",
                env.getRequiredProperty(PROP_DATABASE_URL));
        properties.put(
                "hibernate.current_session_context_class", "thread");
        properties.put(
                "hibernate.show_sql",
                env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(
                "hibernate.hbm2ddl.auto",
                env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

        return properties;
    }
}