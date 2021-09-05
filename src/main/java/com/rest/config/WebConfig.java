package com.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rest.story.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
//	public void addResourceHandler(final ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/webapp/***").addResourceLocations("/webapp/css", "/webapp/js", "/webapp/img");
//	}
	
}
