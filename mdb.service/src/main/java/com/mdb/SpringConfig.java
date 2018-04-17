package com.mdb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.alibaba.druid.pool.DruidDataSource;
import com.ideal.mdb.serviceI.IUser;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.mdb"})
@PropertySource(value={"classpath:jdbc.properties"})
public class SpringConfig {
	@Autowired
	private IUser userServiceImp;
	@Value(value="${oracle.password}")
	private String password;
	@Value(value="${oracle.username}")
	private String username;
	@Value(value="${oracle.driverClassName}")
	private String driverClassName;
	@Value(value="${oracle.url}")
	private String url;
	
	@Bean(name="/login")
	public HessianServiceExporter login(){
		HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
		hessianServiceExporter.setServiceInterface(IUser.class);
		hessianServiceExporter.setService(userServiceImp);
		return hessianServiceExporter;
	}
	
	@Bean(initMethod="init",destroyMethod="close")
	public DataSource druidDataSource(){
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
	
	
}
