package com.softgroup.common.utility.response;

public enum ResponseStatus {
    OK,                    // 200

    BAD_REQUEST,           // 400
    FORBIDDEN,             // 403
    NOT_FOUND,             // 404
    NOT_ACCEPTABLE,        // 406
    UNPROCESSABLE_ENTITY,  // 422
    TOO_MANY_REQUEST,      // 429

    INTERNAL_SERVER_ERROR, // 500
    NOT_IMPLEMENTED        // 501
}
