package com.softgroup.frontend.rest.configuration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher_servlet";

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register( RestAppCfg.class );

        servletContext.addListener( new ContextLoaderListener(ctx) );

        ctx.setServletContext( servletContext );

        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet( DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx) );
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
