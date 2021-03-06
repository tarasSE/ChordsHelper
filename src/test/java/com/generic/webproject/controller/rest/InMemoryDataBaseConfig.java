package com.generic.webproject.controller.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//@Profile("qa")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.generic.webproject.repository")
public class InMemoryDataBaseConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());

        JpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        entityManagerFactoryBean
                .setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean
                .setJpaProperties(getHibernateProperties());
        entityManagerFactoryBean
                .setPackagesToScan("com.generic.webproject.entity");

        return entityManagerFactoryBean;
    }

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        return
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("schema.sql")
                        .addScript("add_test_content.sql")
                        .build();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager
                .setEntityManagerFactory(
                        entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(
                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put(
                "hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        properties.put(
                "hibernate.current_session_context_class", "thread");
        properties.put(
                "hibernate.show_sql", "true");
        properties.put(
                "hibernate.hbm2ddl.auto", "create");

        return properties;
    }
}