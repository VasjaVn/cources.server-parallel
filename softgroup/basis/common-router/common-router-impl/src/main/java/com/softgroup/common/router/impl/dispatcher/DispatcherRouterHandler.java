package com.softgroup.common.router.impl.dispatcher;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import org.springframework.stereotype.Component;

@Component("dispatcherRouterHandler")
public class DispatcherRouterHandler extends AbstractRouterHandler<CommonRouterHandler> {

    private static final String DISPATCHER_TYPE_ROUTER_NAME = "dispatcher";

    @Override
    public String getName() {
        return DISPATCHER_TYPE_ROUTER_NAME;
    }

    @Override
    public String getRouteKey(Request<?> request) {
        return request.getHeader().getType();
    }
}