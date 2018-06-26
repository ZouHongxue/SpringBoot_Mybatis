package com.rrc.learnspring;

import com.alibaba.druid.pool.DruidDataSource;
import com.rrc.learnspring.bean.Mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties({Mysql.class})
public class LearnspringApplication {

    @Autowired
    private Environment env;

    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource(){{
            setUrl(env.getProperty("spring.datasource.url"));
            setUsername(env.getProperty("spring.datasource.username"));
            setPassword(env.getProperty("spring.datasource.password"));
            setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
            setInitialSize(2);
            setMaxActive(20);
            setMinIdle(0);
            setMaxWait(60000);
            setValidationQuery("SELECT 1");
            setTestOnBorrow(false);
            setTestWhileIdle(true);
            setPoolPreparedStatements(false);
        }};
        return dataSource;
    }
    public static void main(String[] args) {
        SpringApplication.run(LearnspringApplication.class, args);
    }
}
