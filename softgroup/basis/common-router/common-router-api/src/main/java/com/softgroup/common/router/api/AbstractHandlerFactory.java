package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHandlerFactory<T extends Handler> implements HandlerFactory<T> {

    @Autowired
    private List<T> listHandlers;

    private Map<String, T> mapHandlers = new HashMap<String, T>();

    @PostConstruct
    public void init() {
        for ( T handler : listHandlers ) {
            mapHandlers.put( handler.getName(), handler );
        }
    }

    @Override
    public T getHandler(Request<?> request) {
        return mapHandlers.get( getKey(request) );
    }

    public abstract String getKey( Request<?> request );
}
