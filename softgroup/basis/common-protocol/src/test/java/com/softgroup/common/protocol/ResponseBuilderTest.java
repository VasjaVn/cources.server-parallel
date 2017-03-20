package com.softgroup.common.protocol;

public class ResponseBuilderTest {
/*
    private String headerUuid = "UUID";
    private String headerOriginUuid = "ORIGIN_UUID";
    private String headerType = "authorization";
    private String headerCommand = "login";
    private String headerVersion = ProtocolVersion.VERSION_1.toString();

    private String dataToken = "TOKEN";

    private Integer statusCode = 200;
    private String statusMessage = "OK";

    private ResponseData loginResponseData;

    private RequestBuilder<RequestData> loginRequestBuilder;

    @Before
    public void init() {
        loginResponseData = new ResponseData();
        loginResponseData.setToken(dataToken);

        loginRequestBuilder = new RequestBuilder<>();
        loginRequestBuilder
                .withOriginUuid(headerOriginUuid)
                .withType(headerType)
                .withCommand(headerCommand);
    }

    @Test
    public void testLoginResponseBuilder() {
        Request<RequestData> loginRequest = loginRequestBuilder.build();

        ResponseBuilder<RequestData, ResponseData> loginResponseBuilder = new ResponseBuilder<>(loginRequest);

        Response<ResponseData> loginResponse = loginResponseBuilder
                                                                .withUuid(headerUuid)
                                                                .withData(loginResponseData)
                                                                .withCode(statusCode)
                                                                .withMessage(statusMessage)
                                                                .build();

         assertNotNull( loginResponse );
         assertNotNull( loginResponse.getHeader() );
         assertThat( loginResponse.getHeader().getUuid(), is(headerUuid) );
         assertThat( loginResponse.getHeader().getOriginUuid(), is(headerOriginUuid) );
         assertThat( loginResponse.getHeader().getType(), is(headerType) );
         assertThat( loginResponse.getHeader().getCommand(), is(headerCommand) );
         assertThat( loginResponse.getHeader().getVersion(), is(headerVersion) );
         assertNotNull( loginResponse.getData() );
         assertThat( loginResponse.getData().getToken(), is(dataToken) );
         assertNotNull( loginResponse.getStatus() );
         assertThat( loginResponse.getStatus().getCode(), is(statusCode) );
         assertThat( loginResponse.getStatus().getMessage(), is(statusMessage) );
    }

    @Test (expected = ProtocolVersionException.class)
    public  void testNotEqualVersionResponseBuilder() {
        Request<RequestData> loginRequest = loginRequestBuilder
                                                            .withVersion("ANOTHER_VERSION")
                                                            .build();

        ResponseBuilder<RequestData, ResponseData> loginResponseBuilder = new ResponseBuilder<>(loginRequest);
    }
    */
}
