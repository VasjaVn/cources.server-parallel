package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetLastTimeOnlineRequestData;
import com.softgroup.profile.api.message.GetLastTimeOnlineResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetLastTimeOnlineHandler
        extends AbstractRequestHandler<GetLastTimeOnlineRequestData, GetLastTimeOnlineResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_LAST_TIME_ONLINE_NAME = "get_last_time_online";

    @Override
    public String getName() {
        return PROF_CMD_GET_LAST_TIME_ONLINE_NAME;
    }

    @Override
    public Response<GetLastTimeOnlineResponseData> commandHandle(Request<GetLastTimeOnlineRequestData> request) {
        return null;
    }
}