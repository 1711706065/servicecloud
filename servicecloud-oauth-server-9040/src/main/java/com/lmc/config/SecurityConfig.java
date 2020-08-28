package com.lmc.config;

import com.lmc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 用户认证和授权管理
 * @author sw
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)	//开启在方法上的保护功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserService userService;
	
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/oauth/**").authorizeRequests()
			.antMatchers("/oauth/**", "/users/**").permitAll()
			.antMatchers("/pro/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and().httpBasic()//开启了httpBasic认证，通过这个当一个未认证
						 //用户访问时就可以通过浏览器弹出一个认证对话框，可以让用户输入用户名和密码进行认证。
			.and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
			.withUser("lmchh")
			.password("12345")
			.roles("USER")
			.and()
			.withUser("sb")
			.password(new BCryptPasswordEncoder().encode("12345"))
			.roles("USER", "ADMIN");
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		// 设置userDetailsService
//		provider.setUserDetailsService(userService);
//		auth.authenticationProvider(provider);

	}

}
