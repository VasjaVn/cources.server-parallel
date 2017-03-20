package com.softgroup.profile.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.api.router.ProfileRouterHandler;
import org.springframework.stereotype.Component;

@Component
public class ProfileTypeRouterHandler
        extends AbstractRouterHandler<ProfileRequestHandler>
        implements ProfileRouterHandler
{
    private static final String PROFILE_TYPE_ROUTER_NAME = "profile";

    @Override
    public String getName() {
        return PROFILE_TYPE_ROUTER_NAME;
    }
}
