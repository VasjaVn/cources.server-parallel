package com.softgroup.common.utility.response;

import com.softgroup.common.protocol.*;

public class ResponseFactory {
    public static <T extends ResponseData, R extends RequestData> Response<T> create(Request<R> request, T data, com.softgroup.common.utility.response.ResponseStatus status) {
        ResponseBuilder<R,T> responseBuilder =
                new ResponseBuilder<R, T>( request );
        responseBuilder.withData(data);

        switch ( status ) {
            case OK: {
                responseBuilder
                        .withCode( 200 )
                        .withMessage( "OK" );
                break;
            }

            case BAD_REQUEST: {
                responseBuilder
                        .withCode( 400 )
                        .withMessage( "Bad request" );
                break;
            }
        }

        return responseBuilder.build();
    }
}
