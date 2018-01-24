package com.deer.config;

import com.deer.annotation.MyBatisDao;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class MyBatisMapperScannerConfig {
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		configurer.setBasePackage("com");
		configurer.setAnnotationClass(MyBatisDao.class);
		return configurer;
	}
}
