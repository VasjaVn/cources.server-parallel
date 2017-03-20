package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.ResponseData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AbstractRequestHandlerTest {

    @Test
    public void testHandle() {
        AbstractRequestHandler<RequestData, ResponseData> abstractRequestHandler = mock(AbstractRequestHandler.class, Mockito.CALLS_REAL_METHODS);

        Request<RequestData> request = new Request<>();
        abstractRequestHandler.handle(request);

        Mockito.verify(abstractRequestHandler).commandHandle(request);
    }
}
