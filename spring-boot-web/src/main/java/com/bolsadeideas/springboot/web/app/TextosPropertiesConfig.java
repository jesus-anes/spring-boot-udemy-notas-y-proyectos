package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Clase para configurar los properties
@Configuration
@PropertySources({ @PropertySource("classpath:textos.properties")
// Para mas configuraciones
// ",@PropertySource("classpath:textos2.properties")"
})
public class TextosPropertiesConfig {

}
