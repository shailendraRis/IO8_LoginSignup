package com.realnet.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.realnet.logging.NoLogging;


/*
 * @EnableGlobalMethodSecurity annotation is what enables the @PreAuthorize annotation.
 * */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {



	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	
	/////

	public void configure12(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

	 


	    @Bean
	    protected CorsConfigurationSource corsConfigurationSource() {
	        final CorsConfiguration configuration = new CorsConfiguration();

	        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
	        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));

	        // NOTE: setAllowCredentials(true) is important,
	        // otherwise, the value of the 'Access-Control-Allow-Origin' header in the response
	        // must not be the wildcard '*' when the request's credentials mode is 'include'.
	        configuration.setAllowCredentials(true);

	        // NOTE: setAllowedHeaders is important!
	        // Without it, OPTIONS preflight request will fail with 403 Invalid CORS request
	        configuration.setAllowedHeaders(Arrays.asList(
	                "Authorization",
	                "Accept",
	                "Cache-Control",
	                "Content-Type",
	                "Origin",
	                "ajax", // <-- This is needed for jQuery's ajax request.
	                "x-csrf-token",
	                "x-requested-with"
	        ));

	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	
	    
	    protected void configure123(HttpSecurity http) throws Exception
	    {
	         http
	        .csrf().disable()
	        .authorizeRequests()
	          .antMatchers("/resources/**").permitAll()
	          .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .and()
	        .httpBasic()
	        .and()
	        .oauth2Login()
	        .and()
	        .cors();
	        
	    }
	    

	
	
	
	
	@NoLogging
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@NoLogging	
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@NoLogging
	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

	@NoLogging
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Filters will not get executed for the resources
		web.ignoring().antMatchers("/", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**",
				"/configuration/**", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**", "/api-docs",
				"/api-docs/**", "/v2/api-docs/**", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.png",
				"/**/*.jpg", "/**/*.gif", "/**/*.svg", "/**/*.ico", "/**/*.ttf", "/**/*.woff", "/**/*.otf");
	}


//	}

	@NoLogging
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// Add CORS Filter //http.cors().and().csrf().disable().
				.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class).authorizeRequests()
				.antMatchers("/token/**").permitAll()
				.antMatchers("/log2/**").permitAll()
				.antMatchers("/api/**").permitAll()
//				 .antMatchers("/SqlworkbenchSqlcont/**").hasRole("ADMIN")			
				 .anyRequest().authenticated()
				.and().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	
	
	}

	/*
	 * http.csrf().disable().exceptionHandling().authenticationEntryPoint(
	 * unauthorizedHandler).and()
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
	 * and().authorizeRequests() .antMatchers("/token/**",
	 * "/signup").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	 * .anyRequest().authenticated();
	 * 
	 * http.addFilterBefore(authenticationTokenFilterBean(),
	 * UsernamePasswordAuthenticationFilter.class);
	 */

	/*
	 * If You want to store encoded password in your databases and authenticate user
	 * based on encoded password then uncomment the below method and provde an
	 * encoder
	 */
	@NoLogging
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	  
	  @Bean
	  public Caffeine caffeineConfig() {
	      return Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES);
	  }
	  @Bean
	  public CacheManager cacheManager(Caffeine caffeine) {
	      CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
	      caffeineCacheManager.setCaffeine(caffeine);
	      return caffeineCacheManager;
	  }


}
