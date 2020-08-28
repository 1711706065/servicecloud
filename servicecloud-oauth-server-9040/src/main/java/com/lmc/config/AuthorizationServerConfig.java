package com.lmc.config;
import com.lmc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * 认证服务器配置
 * 定义OAuth2服务知道的应用程序和用户凭据，哪些用户可以使用服务
 * @author sw
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    // 该对象用来支持 password 模式
    @Autowired
    private AuthenticationManager authenticationManager;
    // 该对象用来将令牌信息存储到内存中
    @Qualifier("jwtTokenStore")
    @Autowired(required = false)
    private TokenStore inMemoryTokenStore;
    // 该对象将为刷新token提供支持
    @Autowired
    private UserService userService;
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    // 指定密码的加密方式
    @Bean
    PasswordEncoder passwordEncoder() {
        // 使用BCrypt强哈希函数加密方案（密钥迭代次数默认为10）
        return new BCryptPasswordEncoder();
    }
    
    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(inMemoryTokenStore)//配置令牌的存储（这里存放在内存中）
                .userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")//配置client_id
                .secret("admin")//配置client-secret
                //.accessTokenValiditySeconds(3600)//配置访问token的有效期
                //.refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                //.redirectUris("http://localhost:9402")//配置redirect_uri，用于授权成功后跳转
                .scopes("webclient", "mobileclient")//配置申请的权限范围
                .resourceIds("res1")
                .authorizedGrantTypes("authorization_code","password", "refresh_token");//配置grant_type，表示授权类型
    }

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security)
			throws Exception {
		// TODO Auto-generated method stub
		security.tokenKeyAccess("permitAll()")// 开启/oauth/token_key验证端口无权限访问
                .checkTokenAccess("permitAll()")// 开启/oauth/check_token验证端口认证权限访问
                .allowFormAuthenticationForClients();
	}



}