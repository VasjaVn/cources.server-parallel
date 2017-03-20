package com.softgroup.common.router.impl.dispatcher;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.HandlerFactory;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dispatcherRouterHandler")
public class DispatcherRouterHandler implements RouterHandler {
    private static final String DISPATCHER_TYPE_ROUTER_NAME = "dispatcher";

    @Autowired
    private HandlerFactory<CommonRouterHandler> routerHandlerFactory;

    @Override
    public String getName() {
        return DISPATCHER_TYPE_ROUTER_NAME;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        RouterHandler routerHandler = routerHandlerFactory.getHandler(msg);
        if ( routerHandler == null ) {
            /* Rewrite this after create utility (factory) for create response*/
            return new ResponseBuilder(msg).withCode(400).withMessage("Bad request").build();
        }
        return routerHandler.handle(msg);
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return null;
    }
}