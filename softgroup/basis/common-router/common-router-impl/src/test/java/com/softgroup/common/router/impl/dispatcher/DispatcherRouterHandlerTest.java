package com.softgroup.common.router.impl.dispatcher;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.impl.factory.RouterTypeHandlerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DispatcherRouterHandlerTest {
    private static final String UNSUPPORT_TYPE = "unsupport_type";

    @Mock
    private RouterTypeHandlerFactory factory;

    @InjectMocks
    private DispatcherRouterHandler dispatcherRouterHandler;

    @Test
    public void testHandleWithBadRequest() {
        Request<?> badRequest = new RequestBuilder()
                                            .withType(UNSUPPORT_TYPE)
                                            .build();

        factory = mock(RouterTypeHandlerFactory.class);
        when(factory.getHandler(badRequest)).thenReturn(null);

        Response<?> response = dispatcherRouterHandler.handle(badRequest);
        Integer responseCode = response.getStatus().getCode();
        String responseMessage = response.getStatus().getMessage();

        assertThat(responseCode, is(400));
        assertThat(responseMessage, is("Bad request"));
    }
}