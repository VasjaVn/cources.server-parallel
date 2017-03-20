package com.softgroup.common.protocol;

public class RequestBuilderTest {
/*
    @Test
    public void testLoginRequestBuilder() {
        String headerUuid = "";
        String headerOriginUuid = "03aedcd3-5638-4887-8c92-43fae4047a5b";
        String headerType = "authorization";
        String headerCommand = "login";
        String headerVersion = "v1.0";

        String dataDeviceToken = "DEVICE_TOKEN";

        RequestData loginRequestData = new LoginRequestData();
        loginRequestData.setDeviceToken(dataDeviceToken);

        RequestBuilder<RequestData> loginRequestBuilder = new RequestBuilder<>();
        Request<RequestData> loginRequest = loginRequestBuilder
                                                        .withOriginUuid(headerOriginUuid)
                                                        .withType(headerType)
                                                        .withCommand(headerCommand)
                                                        .withVersion(headerVersion)
                                                        .withData(loginRequestData)
                                                        .build();

        assertNotNull( loginRequest );
        assertNotNull( loginRequest.getHeader() );
        assertThat( loginRequest.getHeader().getUuid(), is(headerUuid) );
        assertThat( loginRequest.getHeader().getOriginUuid(), is(headerOriginUuid) );
        assertThat( loginRequest.getHeader().getType(), is(headerType) );
        assertThat( loginRequest.getHeader().getCommand(), is(headerCommand) );
        assertThat( loginRequest.getHeader().getVersion(), is(headerVersion) );
        assertNotNull( loginRequest.getData() );
        assertThat( loginRequest.getData().getDeviceToken(), is(dataDeviceToken) );
    }
    */
}
