package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequestData;
import com.softgroup.profile.api.message.SetMyProfileResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class SetMyProfileHandler
        extends AbstractRequestHandler<SetMyProfileRequestData, SetMyProfileResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_SET_MY_PROFILE_NAME = "set_my_profile";

    @Override
    public String getName() {
        return PROF_CMD_SET_MY_PROFILE_NAME;
    }

    @Override
    public Response<SetMyProfileResponseData> commandHandle(Request<SetMyProfileRequestData> request) {
        return null;
    }
}