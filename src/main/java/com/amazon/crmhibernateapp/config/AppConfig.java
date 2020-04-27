package com.amazon.crmhibernateapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.amazon.crmhibernateapp")
public class AppConfig implements WebMvcConfigurer {
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";


    /**
     * This is to configure view path of jsp files
     * */
    @Bean
    public ViewResolver viewResolver()
    {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }


    /**
     * This is to configure resource path to find js or css file
     * REMEMBER IF WE CREATE THE CSS FOLDER IN OTHER RESOURCES DIRECTORY THIS WILL NOT WORK AND SPRING WILL NOT BE ABEL TO FIND CSS
     * HENCE WE CREATED DIRECTORY NAMED RESOURCES IN WEBAPP AND GAVE THE PATH IN JSP FILE
     * <link type="text/css"
     * 		  rel="stylesheet"
     * 		  href="${pageContext.request.contextPath}/resources/css/style.css" />
     * */
//    https://www.baeldung.com/spring-mvc-static-resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }



    /**
     * USE CASE---if we want a welcome or default page and we dont want to configure that in web.xml in old way
     * we use following techiniqye to tell the app that for following default mapping resolve it by loading index.jsp (our welcome page)
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.jsp");
    }

}

