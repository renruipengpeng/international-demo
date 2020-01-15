package com.renruipeng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 配置国际化语言
 * 第二种方案需要将注释放开
 */
@Configuration
public class LocaleConfig {

//    /**
//     * 默认拦截器 其中lang表示切换语言的参数名
//     */
//    @Bean
//    public WebMvcConfigurer localeInterceptor() {
//
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//
////                LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
////                localeInterceptor.setParamName("lang");
////                registry.addInterceptor(localeInterceptor).addPathPatterns("/**");
//
//            }
//        };
//    }
//
//
//    /**
//     * 设置默认语言 (第二种方案需要是用到)
//     * @return
//     */
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.CHINA);
//        return localeResolver;
//    }

}
