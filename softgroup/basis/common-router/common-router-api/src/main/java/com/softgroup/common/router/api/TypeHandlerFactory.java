package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

public class TypeHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> {
    @Override
    public String getKey(Request<?> request) {
        return request.getHeader().getType();
    }
}
