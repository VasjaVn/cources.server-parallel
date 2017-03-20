package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler
        extends AbstractRequestHandler<LoginRequestData, LoginResponseData>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_LOGIN_NAME = "login";

    @Override
    public String getName() {
        return AUTH_CMD_LOGIN_NAME;
    }
    
    @Override
    public Response<LoginResponseData> commandHandle(Request<LoginRequestData> request) {
        /*
            Wrote for testing this method.
            In  the future need rewrite this.
            Using some service with access to DB.
        */
        LoginResponseData data = new LoginResponseData();
        data.setToken("TOKEN_1");

        ResponseBuilder<LoginRequestData, LoginResponseData> builder = new ResponseBuilder<>(request);

        Response<LoginResponseData> response = builder
                                                    .withData(data)
                                                    .withCode(200)
                                                    .withMessage("OK")
                                                    .build();

        return response;
    }
}
