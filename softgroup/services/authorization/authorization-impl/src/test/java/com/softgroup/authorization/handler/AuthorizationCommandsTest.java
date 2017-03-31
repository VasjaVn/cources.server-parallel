package com.softgroup.authorization.handler;

import org.junit.Test;
/*
import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.LoginHandler;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
*/
public class AuthorizationCommandsTest {

    @Test
    public void testCommandLoginHandler() {
  /*     String jsonLoginRequest = "{\"header\":{\"uuid\":\"UUID_1\",\"origin_uuid\":\"ORIGIN_UUID_1\",\"command\":\"login\",\"type\":\"authorization\",\"version\":\"VERSION_1\"},\"data\":{\"device_token\":\"DEVICE_TOKEN_1\"}}";

        Request<?> request = new JacksonDataMapper().mapData(jsonLoginRequest, new TypeReference<Request<?>>() {});

        Response<LoginResponseData> loginResponse = new LoginHandler().handle( request );

        assertThat( loginResponse.getStatus().getCode(), is(200) );
        assertThat( loginResponse.getStatus().getMessage(), is("OK") );
        assertThat( loginResponse.getData().getToken(), is("TOKEN_1") );*/
    }
}