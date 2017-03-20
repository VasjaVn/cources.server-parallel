package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetContactProfilesRequestData;
import com.softgroup.profile.api.message.GetContactProfilesResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetContactProfilesHandler
        extends AbstractRequestHandler<GetContactProfilesRequestData, GetContactProfilesResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_CONTACT_PROFILES_NAME = "get_contact_profiles";

    @Override
    public String getName() {
        return PROF_CMD_GET_CONTACT_PROFILES_NAME;
    }

    @Override
    public Response<GetContactProfilesResponseData> commandHandle(Request<GetContactProfilesRequestData> request) {
        return null;
    }
}