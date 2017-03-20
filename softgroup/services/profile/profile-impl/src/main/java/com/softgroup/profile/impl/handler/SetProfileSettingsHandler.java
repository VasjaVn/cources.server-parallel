package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetProfileSettingsRequestData;
import com.softgroup.profile.api.message.SetProfileSettingsResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class SetProfileSettingsHandler
        extends AbstractRequestHandler<SetProfileSettingsRequestData, SetProfileSettingsResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_SET_PROFILE_SETTINGS_NAME = "set_profile_settings";

    @Override
    public String getName() {
        return PROF_CMD_SET_PROFILE_SETTINGS_NAME;
    }

    @Override
    public Response<SetProfileSettingsResponseData> commandHandle(Request<SetProfileSettingsRequestData> request) {
        return null;
    }
}