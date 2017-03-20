package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

public interface HandlerFactory<T extends Handler> {
    T getHandler(Request<?> request);
}
