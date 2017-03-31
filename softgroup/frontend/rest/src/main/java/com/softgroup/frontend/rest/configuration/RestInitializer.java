package com.softgroup.frontend.rest.configuration;


import com.softgroup.frontend.security.configuration.SecurityRestAppCfg;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class RestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher_servlet";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityRestAppCfg.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { RestAppCfg.class };
    }

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

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}

/*
public class RestInitializer implements WebApplicationInitializer {
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
*/