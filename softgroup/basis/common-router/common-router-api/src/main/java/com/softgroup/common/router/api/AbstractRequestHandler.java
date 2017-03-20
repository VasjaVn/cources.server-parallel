package com.softgroup.common.router.api;


import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

public abstract class AbstractRequestHandler<R extends RequestData, S extends ResponseData> implements RequestHandler {

	@Override
	public Response<S> handle(final Request<?> msg) {
		return commandHandle((Request<R>) msg);
	}

	public abstract Response<S> commandHandle(final Request<R> msg);
}