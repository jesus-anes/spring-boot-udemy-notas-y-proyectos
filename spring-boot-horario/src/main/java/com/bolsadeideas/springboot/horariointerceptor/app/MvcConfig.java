package com.bolsadeideas.springboot.horariointerceptor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier("horarioInterceptor")
	private HandlerInterceptor horarioInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Por defecto, el interceptor se aplica a todas la rutas, por lo que debemos
		// excluir las que no nos interesan
		registry.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
	}

}
