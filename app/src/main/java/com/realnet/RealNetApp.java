package com.realnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@EnableJpaAuditing
@EnableCaching
public class RealNetApp extends SpringBootServletInitializer{
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	    return builder.sources(RealNetApp.class);
	  }
//	
	public static void main(String[] args) {
		SpringApplication.run(RealNetApp.class, args);
		
		
	}
}


