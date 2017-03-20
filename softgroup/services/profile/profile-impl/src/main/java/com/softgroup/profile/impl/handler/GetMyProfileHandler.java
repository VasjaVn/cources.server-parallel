package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.profile.ProfileDaoService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequestData;
import com.softgroup.profile.api.message.GetMyProfileResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMyProfileHandler
        extends AbstractRequestHandler<GetMyProfileRequestData, GetMyProfileResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_MY_PROFILE_NAME = "get_my_profile";

    @Autowired
    private ProfileDaoService daoService;

    @Override
    public String getName() {
        return PROF_CMD_GET_MY_PROFILE_NAME;
    }

    @Override
    public Response<GetMyProfileResponseData> commandHandle(Request<GetMyProfileRequestData> request) {
        ProfileEntity profileEntity2 = daoService.findById("1");

        ResponseBuilder<GetMyProfileRequestData, GetMyProfileResponseData> builder =
                new ResponseBuilder<>(request);
        GetMyProfileResponseData data = new GetMyProfileResponseData();

        /*
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("111");
        profileEntity.setPhoneNumber("222-22-22");
        profileEntity.setCreateDateTime(1111111111L);
        profileEntity.setUpdateDateTime(2222222222L);
        profileEntity.setName("Kolja");
        profileEntity.setAvatarUri("http://my_uri");
        profileEntity.setStatus("I relax");

        data.setProfile(profileEntity);

        return builder.withData(data).withCode(200).withMessage("OK").build();*/
        data.setProfile(profileEntity2);
        return builder.withData(data).withCode(200).withMessage("OK").build();
    }
}