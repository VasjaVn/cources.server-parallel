package com.softgroup.frontend.rest.filter;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.springframework.stereotype.Component;

@Component("publicFilterHandler")
public class PublicFilterHandler extends AbstractFilterHandler {
    private static final String REST_API_PUBLIC_FILTER = "rest_api_public_filter";

    @Override
    public String getName() {
        return REST_API_PUBLIC_FILTER;
    }

    @Override
    protected Response<?> doFilter(Request<?> request) {
        return ( isAuthorizationTypeRouter(request) ? doDispatcherRouterHandler(request) : sendResponseBadRequest(request));
    }
}
