package com.softgroup.common.router.impl.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.common.router.api.CommonRouterHandler;
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
public class RouterTypeHandlerFactoryTest {

    private static final String ROUTER_TYPE_ONE_NAME = "router_one";
    private static final String ROUTER_TYPE_NOT_CORRECT_NAME = "router_type_not_correct";

    @Spy
    private List<CommonRouterHandler> listRouterHandlers = new ArrayList<>();

    @InjectMocks
    private RouterTypeHandlerFactory routerTypeHandlerFactory;

    private CommonRouterHandler routerHandlerOne;
    private CommonRouterHandler routerHandlerTwo;

    private Request<?> request;
    private Request<?> requestWithNotCorrectType;

    @Before
    public void init() {
        routerHandlerOne = mock(CommonRouterHandler.class);

        when(routerHandlerOne.getName()).thenReturn(ROUTER_TYPE_ONE_NAME);

        listRouterHandlers.add(routerHandlerOne);

        routerTypeHandlerFactory.init();

        request = new RequestBuilder<>().withType(ROUTER_TYPE_ONE_NAME).build();
        requestWithNotCorrectType = new RequestBuilder<>().withType(ROUTER_TYPE_NOT_CORRECT_NAME).build();
    }

    @Test
    public void testGetKey() {
        assertThat(routerTypeHandlerFactory.getKey(request), is(ROUTER_TYPE_ONE_NAME));
    }

    @Test
    public void testHandler() {
        assertThat(routerTypeHandlerFactory.getHandler(request), is(routerHandlerOne));
        assertThat(routerTypeHandlerFactory.getHandler(requestWithNotCorrectType), nullValue());
    }
}
