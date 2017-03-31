package com.softgroup.frontend.rest.filter;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Credential;
import com.softgroup.frontend.security.JwtAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component("privateFilterHandler")
public class PrivateFilterHandler extends AbstractFilterHandler {
    private static final String REST_API_PRIVATE_FILTER = "rest_api_private_filter";

    private JwtAuthentication jwtAuthentication;
    private Credential credential;

    @Override
    public String getName() {
        return REST_API_PRIVATE_FILTER;
    }

    @Override
    protected Response<?> doFilter(Request<?> request) {
        if ( !isAuthorizationTypeRouter(request)
              & readCredentialFromSecurityContext()
              & isAuthenticatedRequest() )
        {
            setCredentialForRequest( request );

            return doDispatcherRouterHandler( request );
        } else {
            return sendResponseBadRequest( request );
        }
    }

    private boolean readCredentialFromSecurityContext() {
        jwtAuthentication = (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
        if ( jwtAuthentication != null ) {
            credential = (Credential) jwtAuthentication.getCredentials();
            return (credential != null);
        }
        return false;
    }

    private boolean isAuthenticatedRequest() {
        return jwtAuthentication.isAuthenticated();
    }

    private void setCredentialForRequest(Request<?> request) {
        request.setCredential( credential );
    }
}