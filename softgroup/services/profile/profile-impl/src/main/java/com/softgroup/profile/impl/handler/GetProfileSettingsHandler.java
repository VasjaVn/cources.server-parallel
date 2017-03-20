package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetProfileSettingsRequestData;
import com.softgroup.profile.api.message.GetProfileSettingsResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetProfileSettingsHandler
        extends AbstractRequestHandler<GetProfileSettingsRequestData, GetProfileSettingsResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_PROFILE_SETTINGS_NAME = "get_profile_settings";

    @Override
    public String getName() {
        return PROF_CMD_GET_PROFILE_SETTINGS_NAME;
    }

    @Override
    public Response<GetProfileSettingsResponseData> commandHandle(Request<GetProfileSettingsRequestData> request) {
        return null;
    }
}