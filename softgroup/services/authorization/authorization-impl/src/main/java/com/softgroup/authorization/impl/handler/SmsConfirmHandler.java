package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.RegisterData;
import com.softgroup.authorization.api.message.SmsConfirmRequestData;
import com.softgroup.authorization.api.message.SmsConfirmResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.dao.api.entities.authorization.DeviceEntity;
import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.DeviceDaoService;
import com.softgroup.common.dao.api.service.ProfileDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.token.JwtToken;
import com.softgroup.common.token.JwtTokenPayload;
import com.softgroup.common.token.JwtTokenType;
import com.softgroup.common.utility.cache.CacheUtil;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.common.utility.time.TimeStampUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class SmsConfirmHandler
        extends AbstractRequestHandler<SmsConfirmRequestData, SmsConfirmResponseData>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_SMS_CONFIRM_NAME = "sms_confirm";

    private RegisterData registerData;

    @Autowired
    private DeviceDaoService deviceDaoService;

    @Autowired
    private ProfileDaoService profileDaoService;

    @Override
    public String getName() {
        return AUTH_CMD_SMS_CONFIRM_NAME;
    }

    @Override
    public Response<SmsConfirmResponseData> commandHandle(Request<SmsConfirmRequestData> request) {
        SmsConfirmResponseData data = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        SmsConfirmRequestData requestData =
                new JacksonDataMapper().convert( (Map<String, Object>) request.getData(), SmsConfirmRequestData.class );

        if ( isSmsConfirmSuccess( requestData ) ) {
            String deviceId = UUID.randomUUID().toString();
            String userId   = UUID.randomUUID().toString();

            String deviceToken = generateDeviceToken(deviceId, userId);

            data = new SmsConfirmResponseData();
            data.setDeviceToken( deviceToken );

            writeToDeviceTable( deviceId, userId );
            writeToProfileTable( userId );

            responseStatus = ResponseStatus.OK;
        }

        return ResponseFactory.create(request, data, responseStatus);
    }

    private String generateDeviceToken(String deviceId, String userId) {
        long createdTime = TimeStampUtil.current();
        long expiredTime = TimeStampUtil.expiredBuilder( createdTime )
                                        .addMonths( 6 )
                                        .build();

        JwtTokenPayload jwtTokenPayload = new JwtTokenPayload().builder()
                                                            .withTokenType( JwtTokenType.DEVICE_TOKEN.toString() )
                                                            .withDeviceId( deviceId )
                                                            .withUserId( userId )
                                                            .withCreatedTime( createdTime )
                                                            .withExpiredTime( expiredTime )
                                                            .build();

        return JwtToken.createDeviceToken( jwtTokenPayload );
    }

    private boolean isSmsConfirmSuccess( SmsConfirmRequestData requestData ) {
        String key = requestData.getRegistrationRequestUUID();

        if ( !readRegisterDataFromCache(key) ) return false;

        return registerData.getAuthCode().equals( requestData.getAuthCode() );
    }

    private boolean readRegisterDataFromCache(String key) {
        registerData = (RegisterData) CacheUtil.get(key);
        return (registerData != null);
    }

    private void writeToDeviceTable(String deviceId, String userId) {
        DeviceEntity entity = new DeviceEntity();
        entity.setId( deviceId );
        entity.setDeviceId( registerData.getDeviceId() );
        entity.setUserId( userId );
        entity.setLastConfirmDate( TimeStampUtil.current() );

        deviceDaoService.save(entity);
    }

    private void writeToProfileTable(String userId) {
        ProfileEntity entity = new ProfileEntity();
        entity.setId(userId);
        entity.setPhoneNumber( registerData.getPhoneNumber() );
        long currentTime = TimeStampUtil.current();
        entity.setCreateDateTime( currentTime );
        entity.setUpdateDateTime( currentTime );

        profileDaoService.save(entity);
    }
}