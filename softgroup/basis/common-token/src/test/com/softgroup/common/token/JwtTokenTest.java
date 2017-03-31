package com.softgroup.common.token;

import com.softgroup.common.utility.time.TimeStampUtil;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JwtTokenTest {

    private JwtTokenPayload.Builder builder;
    private long createdTime;

    @Before
    public void init() {
        createdTime = TimeStampUtil.current();

        builder = new JwtTokenPayload.Builder()
                                     .withTokenType(JwtTokenType.DEVICE_TOKEN.toString())
                                     .withDeviceId("DEVICE_ID")
                                     .withUserId("USER_ID");
    }

    @Test
    public void  testTokenIsValid() {
        long expiredTime = TimeStampUtil.expiredBuilder(createdTime)
                                        .addYears(1)
                                        .build();

        JwtTokenPayload jwtTokenPayload = builder.withCreatedTime( createdTime )
                                                 .withExpiredTime( expiredTime )
                                                 .build();

        String token = JwtToken.createDeviceToken( jwtTokenPayload );

        assertThat( JwtToken.validateToken(token), is(JwtTokenStatus.TOKEN_VALID) );
    }

    @Test
    public void testTokenIsNotValid() {
        long expiredTime = TimeStampUtil.expiredBuilder(createdTime)
                                        .addYears(1)
                                        .build();

        JwtTokenPayload jwtTokenPayload = builder.withCreatedTime( createdTime )
                .withExpiredTime( expiredTime )
                .build();

        String token = JwtToken.createDeviceToken( jwtTokenPayload );

        assertThat(JwtToken.validateToken( token.toLowerCase() ), is(JwtTokenStatus.TOKEN_NOT_VALID));
    }

    @Test
    public void testTokenIsFailedExpiredTime() {
        long expiredTime = TimeStampUtil.expiredBuilder(createdTime)
                                        .addYears(-1)
                                        .build();

        JwtTokenPayload jwtTokenPayload = builder.withCreatedTime( createdTime )
                                                 .withExpiredTime( expiredTime )
                                                 .build();

        String token = JwtToken.createDeviceToken( jwtTokenPayload );

        assertThat(JwtToken.validateToken( token ), is(JwtTokenStatus.TOKEN_FAILED_EXPIRED_TIME));
    }
}