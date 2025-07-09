package com.bolsadeideas.springboot.app;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccesHandler;
import com.bolsadeideas.springboot.app.models.dao.service.JpaUserDetailsService;

@Configuration
//Habilitamos la seguridad con anotaciones en los controladores
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {

	@Autowired
	private LoginSuccesHandler successHandler;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Para la conexion a la base de datoss
//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private JpaUserDetailsService userDetailService;

	// Autenticación con JPA
	@Autowired
	public void userDetailsService(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}

//	@Bean
//	public UserDetailsService userDetailsService() throws Exception {
//
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	////Rol de usuario

//		manager.createUser(User.withUsername("jesus").password(passwordEncoder.encode("12345")).roles("USER").build());
	////Rol de admin y usuario
//		manager.createUser(
//				User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN", "USER").build());
//
//		return manager;
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// Acceso público
		http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar", "/locale").permitAll()
						// Acceso de usuarios
						// .requestMatchers("/ver/**", "/uploads/**").hasAnyRole("USER")
						// Acceso de admin
						// .requestMatchers("/form/**", "/eliminar/**", "/factura/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").permitAll()
						// Para el mensaje de inicio de sesion
						.successHandler(successHandler))
				.logout(logout -> logout.permitAll())
				// Redirigimos en caso de no tener permiso
				.exceptionHandling(ex -> ex.accessDeniedPage("/error_403"));

		return http.build();
	}

	// Autenticación JDBC
//	@Bean
//	AuthenticationManager authManager(HttpSecurity http) throws Exception {
//		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//
//		authBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
//				.usersByUsernameQuery("select username, password, enabled from users where username=?")
//				.authoritiesByUsernameQuery(
//						"select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?");
//
//		return authBuilder.build();
//	}

}