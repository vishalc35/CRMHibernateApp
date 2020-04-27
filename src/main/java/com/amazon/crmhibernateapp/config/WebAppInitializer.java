package com.amazon.crmhibernateapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    private static final Logger log = LoggerFactory.getLogger(WebAppInitializer.class);

    private static final String DISPATCHER_NAME="dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Web App Started!!!");


        //create spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_NAME,dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
