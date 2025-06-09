package com.bolsadeideas.springboot.app;

//import java.nio.file.Paths;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

}
