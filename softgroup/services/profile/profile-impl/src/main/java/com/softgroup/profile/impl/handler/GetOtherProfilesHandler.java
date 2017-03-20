package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetOtherProfilesRequestData;
import com.softgroup.profile.api.message.GetOtherProfilesResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetOtherProfilesHandler
        extends AbstractRequestHandler<GetOtherProfilesRequestData, GetOtherProfilesResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_OTHER_PROFILES_NAME = "get_other_profiles";

    @Override
    public String getName() {
        return PROF_CMD_GET_OTHER_PROFILES_NAME;
    }

    @Override
    public Response<GetOtherProfilesResponseData> commandHandle(Request<GetOtherProfilesRequestData> request) {
        return null;
    }
}