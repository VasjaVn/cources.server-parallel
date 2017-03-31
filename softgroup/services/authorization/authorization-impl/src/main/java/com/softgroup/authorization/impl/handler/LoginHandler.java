package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.token.JwtToken;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.common.utility.time.TimeStampUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

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
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;
        LoginResponseData responseData = null;

        LoginRequestData requestData =
                new JacksonDataMapper().convert( (Map<String, Object>)(request.getData()), LoginRequestData.class );

        String deviceToken = requestData.getDeviceToken();
        String token = generateTokenFromDeviceToken( deviceToken );

        if ( token != null ) {
            responseData = new LoginResponseData();
            responseData.setToken( token );
            responseStatus = ResponseStatus.OK;
        }

        return ResponseFactory.create( request, responseData, responseStatus);
    }

    private String generateTokenFromDeviceToken(String deviceToken) {
        long createdTime = TimeStampUtil.current();
        long expiredTime = TimeStampUtil.expiredBuilder(createdTime).addHours(12).build();

        return JwtToken.createTokenFromDeviceToken(deviceToken, createdTime, expiredTime);
    }
}
