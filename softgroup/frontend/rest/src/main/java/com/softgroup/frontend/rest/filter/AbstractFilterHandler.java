package com.softgroup.frontend.rest.filter;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.FilterHandler;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractFilterHandler implements FilterHandler {
    protected static final String AUTHORIZATION_TYPE_ROUTER = "authorization";

    @Autowired
    @Qualifier("dispatcherRouterHandler")
    protected RouterHandler dispatcherRouterHandler;

    @Override
    public Response<?> handle(Request<?> request) {
        return doFilter(request);
    }

    protected boolean isAuthorizationTypeRouter(Request<?> request) {
        return AUTHORIZATION_TYPE_ROUTER.equals( getType(request) );
    }

    protected Response<?> sendResponseBadRequest(Request<?> request) {
        System.out.println("\n\nFilterHandler (BAD) - " + getName() + " { " + request.getHeader().getType() + " : " + request.getHeader().getCommand() + " }");
        return new ResponseBuilder(request).withCode(400).withMessage("Bad request").build();
    }

    protected Response<?> doDispatcherRouterHandler(Request<?> request) {
        System.out.println("\n\nFilterHandler (GOOD) - " + getName() + " { " + request.getHeader().getType() + " : " + request.getHeader().getCommand() + " }");
        return dispatcherRouterHandler.handle(request);
    }

    private String getType(Request<?> request) {
        return request.getHeader().getType();
    }

    protected abstract Response<?> doFilter(Request<?> request);
}