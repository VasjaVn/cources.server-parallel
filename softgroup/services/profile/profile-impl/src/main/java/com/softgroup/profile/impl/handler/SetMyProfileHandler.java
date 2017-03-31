package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.ProfileDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.profile.api.message.SetMyProfileRequestData;
import com.softgroup.profile.api.message.SetMyProfileResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SetMyProfileHandler
        extends AbstractRequestHandler<SetMyProfileRequestData, SetMyProfileResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_SET_MY_PROFILE_NAME = "set_my_profile";

    @Autowired
    private ProfileDaoService profileDaoService;

    @Override
    public String getName() {
        return PROF_CMD_SET_MY_PROFILE_NAME;
    }

    @Override
    public Response<SetMyProfileResponseData> commandHandle(Request<SetMyProfileRequestData> request) {
        updateTableProfile(request);
        SetMyProfileResponseData responseData = new SetMyProfileResponseData();
        return ResponseFactory.create(request, responseData, ResponseStatus.OK);
    }

    private void updateTableProfile( Request<SetMyProfileRequestData> request ) {
        SetMyProfileRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), SetMyProfileRequestData.class);

        String userId = request.getCredential().getUserId();

        ProfileEntity entity = profileDaoService.findById(userId);
        entity.setPhoneNumber( requestData.getProfile().getPhoneNumber() );
        entity.setName( requestData.getProfile().getName()) ;
        entity.setAvatarUri( requestData.getProfile().getAvatarUri() );
        entity.setStatus( requestData.getProfile().getStatus() );

        profileDaoService.save(entity);
    }
}