package com.mdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.ideal.mdb.serviceI.IUser;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.mdb"})
public class SpringConfig {
	@Autowired
	private IUser userServiceImp;
	
	@Bean(name="/login")
	public HessianServiceExporter login(){
		HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
		hessianServiceExporter.setServiceInterface(IUser.class);
		hessianServiceExporter.setService(userServiceImp);
		return hessianServiceExporter;
	}
}
