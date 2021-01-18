package br.com.hivecloud.msbookregister.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
	
	private static final String[] PUBLIC_MATCHERS_GET = { "/books/**","/users/**" };
	
	private static final String[] PUBLIC_MATCHERS_POST = { "/books/**", "/users/books"}; 

	/**
	 * Responsible to configure user login
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password(passwordEncoder().encode("Test@1234"))
			.roles("USER")
			.and()
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.cors().and().csrf().disable(); //allow cors
		 
		 http.csrf().disable().authorizeRequests()
		 .antMatchers("/actuator/**").permitAll()
         .antMatchers("/swagger-ui.html").permitAll()
         .antMatchers("/swagger-resources/**").permitAll()
         .antMatchers("/webjars/**").permitAll()
         .antMatchers("/v2/api-docs/**").permitAll()
         .antMatchers("/").permitAll()
         .antMatchers("/csrf").permitAll()
         .antMatchers("/*.js").permitAll()
         .antMatchers("/*.css").permitAll()
         .antMatchers("/*.ico").permitAll()
         .antMatchers("/*.png").permitAll()
         .antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
         .antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
         .anyRequest().authenticated()
         .and().httpBasic()
         .and()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Configurarion to permit cors endpoint
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE","OPTIONS")); 
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);
		
		return source;
	}
	
}
