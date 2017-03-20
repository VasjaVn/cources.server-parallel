package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationTypeRouterHandler
        extends AbstractRouterHandler<AuthorizationRequestHandler>
        implements AuthorizationRouterHandler
{
    private static final String AUTHORIZATION_TYPE_ROUTER_NAME = "authorization";

    @Override
    public String getName() {
        return AUTHORIZATION_TYPE_ROUTER_NAME;
    }
}
