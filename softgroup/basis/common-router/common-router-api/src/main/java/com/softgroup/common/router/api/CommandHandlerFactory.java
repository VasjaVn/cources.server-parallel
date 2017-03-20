package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

public class CommandHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> {

    @Override
    public String getKey(Request<?> request) {
        return request.getHeader().getCommand();
    }
}
