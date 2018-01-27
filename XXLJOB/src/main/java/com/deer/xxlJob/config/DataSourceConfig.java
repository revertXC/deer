package com.deer.xxlJob.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {
    @Value("${druid.stat.loginUsername}")
    private String loginUsername;

    @Value("${druid.stat.loginPassword}")
    private String loginPassword;

    @Value("${datasource.type}")
    private String datasourceType;

    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/"+datasourceType+"/**/mapper/impl/*.xml"));

        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pagePlugin()});

        return sqlSessionFactoryBean.getObject();
    }

    private PageHelper pagePlugin(){

        PageHelper pageHelper = new PageHelper();

        Properties properties = new Properties();
        properties.setProperty("dialect", datasourceType);
        properties.setProperty("reasonable", "true");

        pageHelper.setProperties(properties);

        return pageHelper;
    }

}
