package com.twitReplico.TwitCloneArtifact.config;

import org.apache.camel.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
//WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		 http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		 http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/token/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//	            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	            .httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
