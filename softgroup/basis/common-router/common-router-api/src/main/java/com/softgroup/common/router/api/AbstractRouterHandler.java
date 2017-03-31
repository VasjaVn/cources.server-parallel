package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

	@Autowired
	protected HandlerFactory<T> handlerFactory;

	@Override
	public String getRouteKey(Request<?> request) {
		return null;
	}

	@Override
	public Response<?> handle(Request<?> request) {
		Handler handler = handlerFactory.getHandler(request);
		return ( handler != null ? doHandler(handler, request) : sendResponseBadRequest(request) );
	}

	private Response<?> doHandler(Handler handler, Request<?> request) {
		System.out.println("Handler (GOOD) - " + getName() + " { " + request.getHeader().getType() + " : " + request.getHeader().getCommand() + " }");
		return handler.handle(request);
	}

	private Response<?> sendResponseBadRequest(Request<?> request) {
		System.out.println("Handler (BAD) - " + getName() + " { " + request.getHeader().getType() + " : " + request.getHeader().getCommand() + " }");
		return new ResponseBuilder( request ).withCode(400).withMessage("Bad request").build();
	}
}