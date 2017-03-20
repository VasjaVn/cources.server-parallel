package com.softgroup.authorization.factory;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.factory.AuthorizationCommandHandlerFactory;
import com.softgroup.authorization.impl.handler.LoginHandler;
import com.softgroup.authorization.impl.handler.RegisterHandler;
import com.softgroup.authorization.impl.handler.SmsConfirmHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationCommandHandlerFactoryTest {

    @Spy
    private List<AuthorizationRequestHandler> listHandlers = new ArrayList<>();

    @InjectMocks
    private AuthorizationCommandHandlerFactory factory;

    private AuthorizationRequestHandler authCmdRegisterHandler = new RegisterHandler();
    private AuthorizationRequestHandler authCmdSmsConfirmHandler = new SmsConfirmHandler();
    private AuthorizationRequestHandler authCmdLoginHandler = new LoginHandler();

    private String authorizationTypeName = "authorization";

    private String commandRegisterName = "register";
    private String commandSmsConfirmName = "sms_confirm";
    private String commandLoginName = "login";

    private Request<?> registerRequest;
    private Request<?> smsConfirmRequest;
    private Request<?> loginRequest;

    @Before
    public void init() {
        listHandlers.add( authCmdRegisterHandler );
        listHandlers.add( authCmdSmsConfirmHandler );
        listHandlers.add( authCmdLoginHandler );

        factory.init();

        RequestBuilder<?> builderRegisterRequest = new RequestBuilder<>();
        registerRequest = builderRegisterRequest
                                            .withType( authorizationTypeName )
                                            .withCommand( commandRegisterName )
                                            .build();

        RequestBuilder<?> builderSmsConfirmRequest = new RequestBuilder<>();
        smsConfirmRequest = builderSmsConfirmRequest
                                            .withType( authorizationTypeName )
                                            .withCommand( commandSmsConfirmName )
                                            .build();

        RequestBuilder<?> builderLoginRequest = new RequestBuilder<>();
        loginRequest = builderLoginRequest
                                        .withType( authorizationTypeName )
                                        .withCommand( commandLoginName )
                                        .build();
    }

    @Test
    public void testGetKey() {
        assertThat( factory.getKey( registerRequest ), is(commandRegisterName));
        assertThat( factory.getKey( smsConfirmRequest ), is(commandSmsConfirmName));
        assertThat( factory.getKey( loginRequest ), is(commandLoginName));
    }

    @Test
    public void testGetHandler() {
        assertThat( factory.getHandler( registerRequest ), is(authCmdRegisterHandler) );
        assertThat( factory.getHandler( smsConfirmRequest ), is(authCmdSmsConfirmHandler));
        assertThat( factory.getHandler( loginRequest ), is(authCmdLoginHandler));
    }
}
