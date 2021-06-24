package com.simplyDemo.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.simplyDemo.demo.web.ViewResolver.HOME_VIEW;
import static com.simplyDemo.demo.web.ViewResolver.ROOT_VIEW;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(ROOT_VIEW).setViewName(HOME_VIEW);
        registry.addViewController(ROOT_VIEW + HOME_VIEW).setViewName(HOME_VIEW);
    }

}
