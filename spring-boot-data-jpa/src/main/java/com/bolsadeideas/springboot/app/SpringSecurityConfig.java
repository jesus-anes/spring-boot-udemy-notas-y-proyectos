package com.bolsadeideas.springboot.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() throws Exception {

		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//Rol de usuario
		manager.createUser(
				User.withUsername("jesus").password(passwordEncoder().encode("12345")).roles("USER").build());
//Rol de admin y usuario
		manager.createUser(
				User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER").build());

		return manager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// Acceso público
		http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
						// Acceso de usuarios
						.requestMatchers("/ver/**", "/uploads/**").hasAnyRole("USER")
						// Acceso de admin
						.requestMatchers("/form/**", "/eliminar/**", "/factura/**").hasRole("ADMIN").anyRequest()
						.authenticated())
				.formLogin(login -> login.loginPage("/login").permitAll()).logout(logout -> logout.permitAll())
				// Redirigimos en caso de no tener permiso
				.exceptionHandling(ex -> ex.accessDeniedPage("/error_403"));
		return http.build();
	}

}