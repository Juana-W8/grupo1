package com.SistemaMarticulas.Matriculas;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@SuppressWarnings("deprecation")
@SpringBootApplication
public class MatriculasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MatriculasApplication.class, args);
	}
	
	@EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "HEAD"));
            configuration.setExposedHeaders(Arrays.asList("Authorization"));
            configuration.setAllowedOrigins(Arrays.asList("*"));
            
            http.addFilterAfter(new Jwtfilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers(HttpMethod.POST,"/api/token").permitAll()
            .antMatchers(HttpMethod.POST,"/api/usuarios").permitAll()
            .antMatchers(HttpMethod.GET, "/api/estudiantes").hasAuthority("admin")
            .antMatchers(HttpMethod.DELETE, "/api/estudiantes").hasAuthority("admin")
            .anyRequest().authenticated()
            .and()
            .csrf().disable().cors().configurationSource(request -> configuration);
        }
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder spring) {
		return spring.sources(MatriculasApplication.class);
	}
}

