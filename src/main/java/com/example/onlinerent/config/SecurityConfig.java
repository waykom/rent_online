package com.example.onlinerent.config;

import com.example.onlinerent.model.RespBean;
import com.example.onlinerent.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig {

    /**
     * 配置 Spring Security 过滤器链
     *
     * @return
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //这个表示拦截所有请求
//        AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/**");
//        return new DefaultSecurityFilterChain(requestMatcher);
        http
                //开启配置
                .authorizeRequests()
                //拦截所有请求
                .anyRequest()
                //所有请求都需要登录之后才可以访问
                .authenticated()
                .and()
                //开启表单登录配置
                .formLogin()
                //请求成功处理器
                .successHandler((request, response, authentication) -> {
                    //获取当前登录成功的用户对象
                    User principal = (User) authentication.getPrincipal();
                    principal.setPassword(null);
                    RespBean respBean = RespBean.ok("登录成功", principal);
                    //将对象转为 JSON 字符串
                    String json = new ObjectMapper().writeValueAsString(respBean);
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().write(json);
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        RespBean respBean = RespBean.error("登录失败");
                        if (exception instanceof BadCredentialsException) {
                            //说明是用户密码输入错误，登录失败
                            respBean.setMessage("用户名或者密码输入错误，登录失败");
                        } else if (exception instanceof AccountExpiredException) {
                            respBean.setMessage("账户过期，登录失败");
                        } else if (exception instanceof CredentialsExpiredException) {
                            respBean.setMessage("密码过期，登录失败");
                        } else if (exception instanceof DisabledException) {
                            respBean.setMessage("账户被禁用，登录失败");
                        }
                        String json = new ObjectMapper().writeValueAsString(respBean);
                        response.setContentType("application/json;charset=utf-8");
                        response.getWriter().write(json);
                    }
                })
                //用户名参数的 key，默认就是 username
                .usernameParameter("name")
                //密码参数的 key，默认就是 password
                .passwordParameter("passwd")
                //配置登录接口，登录接口默认就是 /login
                .loginProcessingUrl("/doLogin")
                //配置登录页面，默认情况下，登录页面地址是 /login
                .loginPage("/login.html")
                //允许和登录相关的地址通过
                .permitAll()
                .and()
                //移除 CSRF 过滤器
                .csrf()
                .disable()
                //配置异常处理器
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    /**
                     * 如果用户没有认证，就去访问一个需要认证之后才能访问的资源，就会触发该方法
                     * @param request
                     * @param response
                     * @param authException
                     * @throws IOException
                     * @throws ServletException
                     */
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        String json = new ObjectMapper().writeValueAsString(RespBean.error("尚未登录，请先登录"));
                        PrintWriter out = response.getWriter();
                        out.write(json);
                    }
                })
                .and()
                //                注销
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        RespBean respBean = RespBean.ok("注销成功");
                        String json = new ObjectMapper().writeValueAsString(respBean);
                        response.setContentType("application/json;charset=utf-8");
                        response.getWriter().write(json);
                    }
                });
        return http.build();
    }
}

