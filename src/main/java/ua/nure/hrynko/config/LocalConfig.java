package ua.nure.hrynko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;


@Configuration
public class LocalConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("local");
        return lci;
    }

    //SessionLocaleResolver
    @Bean
    public LocaleResolver localeResolver() {
//        final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("ru", "RU"));
//        return localeResolver;
        return new SessionLocaleResolver();
    }
//    @Bean
//    public LocaleResolver localeResolver() {
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setCookieDomain("localhost");
//        // 60 minutes
//        resolver.setCookieMaxAge(60 * 60);
//        return resolver;
//    }

}
