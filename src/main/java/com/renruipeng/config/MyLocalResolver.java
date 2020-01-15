package com.renruipeng.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Mr--renruipeng
 * @date 2019-12-30
 * 第一种方案的配置
 **/
@Configuration
@Slf4j
public class MyLocalResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        Locale locale = request.getLocale();

        if (locale == null) {

            locale = new Locale(Locale.CHINA.getLanguage());

        }

        String language = locale.getLanguage();

        log.info("取到的语言是:{}", language);

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

}
