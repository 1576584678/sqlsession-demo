package com.example.sqlsessiondemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/12/10
 */
@Configuration
public class SqlSessionFactoryConfig {

    @Resource
    DataSource dataSource;

    @Bean
    @Primary
    public SqlSessionFactory sqlSession() {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        try {
            //设置对应的xml文件地址
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/*.xml"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory factory=null;
        try {
            factory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
}

