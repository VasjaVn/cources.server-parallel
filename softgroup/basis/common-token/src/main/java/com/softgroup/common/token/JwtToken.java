package com.softgroup.common.token;

import com.softgroup.common.utility.time.TimeStampUtil;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

import static com.softgroup.common.token.JwtTokenStatus.*;

public final class JwtToken {
    private static final int COUNT_PARTS_CORRECT_TOKEN = 3;

    private static final String VALUE_KEY_SIGNING = "secret";

    private static final String HEADER_VALUE_TYP = "JWT";

    private static final String PAYLOAD_KEY_TOKEN_TYPE   = "token_type";
    private static final String PAYLOAD_KEY_DEVICE_ID    = "device_id";
    private static final String PAYLOAD_KEY_USER_ID      = "user_id";
    private static final String PAYLOAD_KEY_CREATED_TIME = "created_time";
    private static final String PAYLOAD_KEY_EXPIRED_TIME = "expired_time";

    private static Header header;
    private static SignatureAlgorithm signatureAlgorithm;
    private static Key key;

    static {
        header = Jwts.jwsHeader().setType( HEADER_VALUE_TYP );

        signatureAlgorithm = SignatureAlgorithm.HS256;

        key = new SecretKeySpec(
                DatatypeConverter.parseBase64Binary( VALUE_KEY_SIGNING ),
                signatureAlgorithm.getJcaName()
        );
    }

    private JwtToken() {
    }

    public static String createDeviceToken(JwtTokenPayload jwtTokenPayload) {
        return createTokenHelper(jwtTokenPayload);
    }

    public static String createTokenFromDeviceToken(String deviceToken, Long createdTime, Long expiredTime) {
        JwtTokenPayload jwtTokenPayload = parser().getJwtTokenPayload( deviceToken );

        if ( jwtTokenPayload == null ) return null;

        jwtTokenPayload.setTokenType( JwtTokenType.TOKEN.toString() );
        jwtTokenPayload.setCreatedTime( createdTime );
        jwtTokenPayload.setExpiredTime( expiredTime );

        return createTokenHelper(jwtTokenPayload);
    }

    public static JwtTokenStatus validateToken(String token) {
        if ( !isTokenCorrect(token) ) return TOKEN_NOT_CORRECT;
        return ( isValidSignature(token) ? ( isFailedExpiredTime(token) ? TOKEN_FAILED_EXPIRED_TIME : TOKEN_VALID ) : TOKEN_NOT_VALID );
    }

    public static JwtTokenParser parser() { return new JwtTokenParser(); }

    private static boolean isValidSignature(String token) {
        String jwtWithoutSignature = parser().getJwtWithoutSignature(token);
        String base64UrlEncodedSignature = parser().getBase64UrlEncodedSignature(token);

        JwtSignatureValidator jwtSignatureValidator =
                new DefaultJwtSignatureValidator(signatureAlgorithm, key);

        return jwtSignatureValidator.isValid( jwtWithoutSignature, base64UrlEncodedSignature );
    }

    private static boolean isFailedExpiredTime(String token) {
        long expiredTime = parser().getJwtTokenPayload(token)
                                   .getExpiredTime();

        return TimeStampUtil.isExpiredTimeBeforeCurrentTime(expiredTime);
    }

    private static String createTokenHelper(JwtTokenPayload jwtTokenPayload) {
        Claims payload = Jwts.claims();
        payload.put( PAYLOAD_KEY_TOKEN_TYPE,   jwtTokenPayload.getTokenType()   );
        payload.put( PAYLOAD_KEY_DEVICE_ID,    jwtTokenPayload.getDeviceId()    );
        payload.put( PAYLOAD_KEY_USER_ID,      jwtTokenPayload.getUserId()      );
        payload.put( PAYLOAD_KEY_CREATED_TIME, String.valueOf( jwtTokenPayload.getCreatedTime() ) );
        payload.put( PAYLOAD_KEY_EXPIRED_TIME, String.valueOf( jwtTokenPayload.getExpiredTime() ) );

        return Jwts.builder()
                   .setHeader( (Map<String, Object>)header )
                   .setClaims( payload )
                   .signWith( signatureAlgorithm, key )
                   .compact();
    }

    private static boolean isTokenCorrect(String token) {
        if ( token == null ) return false;
        if ( token.isEmpty() ) return false;
        if ( token.split("\\.").length != COUNT_PARTS_CORRECT_TOKEN ) return false;

        return true;
    }

    public static final class JwtTokenParser {

        public JwtTokenPayload getJwtTokenPayload( String token ) {
            try {
                Claims claims = Jwts.parser()
                                    .setSigningKey(key)
                                    .parseClaimsJws(token)
                                    .getBody();

                return new JwtTokenPayload().builder()
                                            .withTokenType( (String) claims.get(PAYLOAD_KEY_TOKEN_TYPE) )
                                            .withDeviceId( (String) claims.get(PAYLOAD_KEY_DEVICE_ID) )
                                            .withUserId( (String) claims.get(PAYLOAD_KEY_USER_ID) )
                                            .withCreatedTime( Long.parseLong( (String) claims.get(PAYLOAD_KEY_CREATED_TIME)) )
                                            .withExpiredTime( Long.parseLong( (String) claims.get(PAYLOAD_KEY_EXPIRED_TIME)) )
                                            .build();

            } catch ( JwtException | ClassCastException ex ) {
                return null;
            }
        }

        public String getJwtWithoutSignature(String token) {
            String pieces[] = token.split("\\.");
            return pieces[0] + "." + pieces[1];
        }

        public String getBase64UrlEncodedSignature(String token) {
            return token.split("\\.")[2];
        }
    }
}