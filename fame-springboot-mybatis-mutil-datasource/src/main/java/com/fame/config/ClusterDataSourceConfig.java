package com.fame.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多数据源配置
 *
 * @author Y.yang
 * @date 2019/4/24
 */
@Configuration
/**扫描 Mapper 接口并容器管理*/
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

    static final String PACKAGE = "com.fame.mapper.cluster";
	static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

	@Bean(name = "clusterDataSource")
	@ConfigurationProperties(prefix = "cluster.datasource")
	public DataSource clusterDataSource() {
		return DataSourceBuilder.create().build();

	}

	@Bean(name = "clusterTransactionManager")
	public DataSourceTransactionManager clusterTransactionManager() {
		return new DataSourceTransactionManager(clusterDataSource());
	}

	@Bean(name = "clusterSqlSessionFactory")
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(clusterDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}