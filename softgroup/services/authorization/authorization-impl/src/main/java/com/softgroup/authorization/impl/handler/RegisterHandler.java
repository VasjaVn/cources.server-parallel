package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.RegisterData;
import com.softgroup.authorization.api.message.RegisterRequestData;
import com.softgroup.authorization.api.message.RegisterResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.cache.CacheUtil;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class RegisterHandler
        extends AbstractRequestHandler<RegisterRequestData, RegisterResponseData>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_REGISTER_NAME = "register";

    @Override
    public String getName() {
        return AUTH_CMD_REGISTER_NAME;
    }

    @Override
    public Response<RegisterResponseData> commandHandle(Request<RegisterRequestData> request) {
        RegisterRequestData requestData =
                new JacksonDataMapper().convert( (Map<String, Object>)(request.getData()), RegisterRequestData.class );

        RegisterData registerData =
                getRegisterDataFrom( requestData );

        saveRegisterDataToCache(registerData);

        RegisterResponseData responseData =
                getRegisterResponseDataFrom( registerData );

        return ResponseFactory.create( request, responseData, ResponseStatus.OK);
    }

    private RegisterData getRegisterDataFrom(RegisterRequestData requestData) {
        RegisterData registerData = new RegisterData();

        registerData.setPhoneNumber( requestData.getPhoneNumber() );
        registerData.setDeviceId( requestData.getDeviceID() );
        registerData.setLocaleCode( requestData.getLocaleCode() );

        registerData.setRegistrationRequestUuid( UUID.randomUUID().toString() );
        registerData.setAuthCode( generateAuthCode() );
        registerData.setRegistrationTimeoutSec( CacheUtil.TIME_TO_LIVE_MILLIS );

        return registerData;
    }

    private void saveRegisterDataToCache(RegisterData registerData) {
        String key = registerData.getRegistrationRequestUuid();
        CacheUtil.put( key, registerData );
    }

    private RegisterResponseData getRegisterResponseDataFrom(RegisterData registerData) {
        RegisterResponseData responseData = new RegisterResponseData();
        responseData.setRegistrationRequestUUID( registerData.getRegistrationRequestUuid() );
        responseData.setRegistrationTimeoutSec( registerData.getRegistrationTimeoutSec() );
        responseData.setAuthCode( registerData.getAuthCode() );

        return responseData;
    }

    private String generateAuthCode() {
        return "111";
    }
}