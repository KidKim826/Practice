package com.boot.board.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
//	#prefix suffix
//	spring.mvc.view.prefix=/WEB-INF/views/
//	spring.mvc.view.suffix=.jsp
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix;
	
	@Bean
	public ViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public ViewResolver beanViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addInterceptors(registry);
//	}
//	
	
	
	

}
