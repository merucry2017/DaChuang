package com.library.smart_library.config;

import com.library.smart_library.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index*").setViewName("index");
        registry.addViewController("/login*").setViewName("login");
        registry.addViewController("/user/login*").setViewName("login");
        registry.addViewController("/register*").setViewName("register");
        registry.addViewController("/user/register*").setViewName("register");
        registry.addViewController("/favorites*").setViewName("favorites");
        registry.addViewController("/password*").setViewName("password");
        registry.addViewController("/search*").setViewName("search");
        registry.addViewController("/userdata*").setViewName("userdata");
        registry.addViewController("/book*").setViewName("book");
        registry.addViewController("/*/details").setViewName("book");
        registry.addViewController("/comment*").setViewName("comment");
        registry.addViewController("/change_password*").setViewName("password");
        registry.addViewController("/question*").setViewName("question");
        registry.addViewController("/myquestion*").setViewName("myquestion");
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new LanguageLocaleResolverConfig();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        // 拦截路径：必须登录才可以访问
        List<String> patterns = new ArrayList<>();
        patterns.add("/**");

        // 白名单：在黑名单范围内，却不需要登录就可以访问
        List<String> excludePatterns = new ArrayList<>();
        excludePatterns.add("/bootstrap3/**");
        excludePatterns.add("/css/**");
        excludePatterns.add("/js/**");
        excludePatterns.add("/asserts/**");
        excludePatterns.add("/bootstrap/**");
        excludePatterns.add("/static/**");
        excludePatterns.add("/webjars/**");

        excludePatterns.add("/templates/register.html");
        excludePatterns.add("/user/register*");
        excludePatterns.add("/templates/login.html");
        excludePatterns.add("/user/login*");
        excludePatterns.add("/register*");
        excludePatterns.add("/login*");
        excludePatterns.add("/");


        // 注册拦截器
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }
}
