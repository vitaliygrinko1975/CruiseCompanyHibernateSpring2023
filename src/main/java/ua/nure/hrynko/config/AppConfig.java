package ua.nure.hrynko.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

@Configuration
@EnableScheduling
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"ua.nure.hrynko.db.dao",
        "ua.nure.hrynko.servise"})
@Import({SecurityConfig.class})
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("sql.driver"));
        dataSource.setUrl(env.getProperty("sql.url"));
        dataSource.setUsername(env.getProperty("sql.username"));
        dataSource.setPassword(env.getProperty("sql.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.cruises"));
        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.context", env.getProperty("hibernate.context"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("ua.nure.hrynko.db.models");
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }


}