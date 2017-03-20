package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactsSyncRequestData;
import com.softgroup.profile.api.message.ContactsSyncResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class ContactsSyncHandler
        extends AbstractRequestHandler<ContactsSyncRequestData, ContactsSyncResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_CONTACTS_SYNC_NAME = "contacts_sync";

    @Override
    public String getName() {
        return PROF_CMD_CONTACTS_SYNC_NAME;
    }

    @Override
    public Response<ContactsSyncResponseData> commandHandle(Request<ContactsSyncRequestData> request) {
        return null;
    }
}