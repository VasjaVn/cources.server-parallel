package com.softgroup.messenger.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.api.router.MessengerRouterHandler;
import org.springframework.stereotype.Component;

@Component
public class MessengerTypeRouterHandler
        extends AbstractRouterHandler<MessengerRequestHandler>
        implements MessengerRouterHandler
{
    private static final String MESSENGER_TYPE_ROUTE_NAME = "messenger";

    @Override
    public String getName() {
        return MESSENGER_TYPE_ROUTE_NAME;
    }
}
