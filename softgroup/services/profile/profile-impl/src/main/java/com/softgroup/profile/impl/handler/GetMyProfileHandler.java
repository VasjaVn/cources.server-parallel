package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.ProfileDaoService;
import com.softgroup.common.protocol.Credential;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
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

        Credential credential = request.getCredential();

        String userId = credential.getUserId();

        ProfileEntity entity = daoService.findById(userId);

        GetMyProfileResponseData data = new GetMyProfileResponseData();
        data.setProfile(entity);

        return ResponseFactory.create(request, data, ResponseStatus.OK);
        //return ResponseFactory.create(request, null, ResponseStatus.OK);
    }

    private Credential getCredential(Request<?> request) {
        return request.getCredential();
    }

}