package com.bolsadeideas.springboot.app;

import java.util.Locale;

import org.springframework.context.annotation.Bean;

//import java.nio.file.Paths;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	// Usaremos otro método para pasar la imagen con el request

	// Para mostrar datos en consola
	// private final Logger log = LoggerFactory.getLogger(getClass());

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * 
	 * // Para agregar directorios a nuestro proyecto, en este caso para las
	 * imagenes WebMvcConfigurer.super.addResourceHandlers(registry);
	 * 
	 * String resourcePath =
	 * Paths.get("uploads").toAbsolutePath().toUri().toString();
	 * log.info(resourcePath);
	 * 
	 * // Para un directorio fuera de nuestro proyecto //
	 * registry.addResourceHandler("/uploads/**").addResourceLocations(
	 * "file:/C:/Temp/uploads/");
	 * 
	 * // Directorio dentro de nuestro proyecto
	 * registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath)
	 * ; }
	 */

	// Metodo para registrar un controlador de vistas
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Configurar el idioma
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es", "ES"));
		return localeResolver;
	}

	@Bean
	// Interceptor para cambiar el lenguaje
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	// Registramos el interceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());
	}

}
