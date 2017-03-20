package com.softgroup.profile.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.factory.ProfileCommandHandlerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProfileCommandHandlerFactoryTest {

    private static final String PROFILE_TYPE_NAME = "PROFILE";

    private static final String CMD_HANDLER_GOOD_NAME = "CMD_HANDLER_GOOD_NAME";
    private static final String CMD_HANDLER_BAD_NAME  = "CMD_HANDLER_BAD_NAME";

    @Spy
    private List<ProfileRequestHandler> listHandlers = new ArrayList<>();

    @InjectMocks
    private ProfileCommandHandlerFactory factory;

    private ProfileRequestHandler cmdHandlerGood;

    private Request<?> goodRequest;
    private Request<?> badRequest;


    @Before
    public void init() {
        cmdHandlerGood = mock(ProfileRequestHandler.class);
        when(cmdHandlerGood.getName()).thenReturn(CMD_HANDLER_GOOD_NAME);

        listHandlers.add(cmdHandlerGood);

        factory.init();

        RequestBuilder<?> requestBuilder = new RequestBuilder<>();
        goodRequest = requestBuilder
                                .withType(PROFILE_TYPE_NAME)
                                .withCommand(CMD_HANDLER_GOOD_NAME)
                                .build();

        requestBuilder = new RequestBuilder<>();
        badRequest = requestBuilder
                                .withType(PROFILE_TYPE_NAME)
                                .withCommand(CMD_HANDLER_BAD_NAME)
                                .build();
    }

    @Test
    public void testGetKey() {
        assertThat( factory.getKey(goodRequest), is(CMD_HANDLER_GOOD_NAME) );
    }

    @Test
    public void testGetHandler() {
        assertThat( factory.getHandler(goodRequest), is(cmdHandlerGood) );
        assertThat( factory.getHandler(badRequest), nullValue() );
    }
}
