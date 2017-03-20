package com.softgroup.common.protocol;

import com.softgroup.common.exceptions.ProtocolVersionException;

import java.util.UUID;

public class ResponseBuilder<R extends RequestData,T extends ResponseData> {

    private String uuid = UUID.randomUUID().toString();
    private String originUuid;
    private String type;
    private String command;
    private String version = ProtocolVersion.VERSION_1.toString();

    private T data;

    private Integer code;
    private String message;

    public ResponseBuilder(Request<R> request) {
        if ( !version.equals(request.getHeader().getVersion()) ) {
            throw new ProtocolVersionException("Version of Header of Request: " + request.getHeader().getVersion() + " not equal with Version of Header of Response: " + version );
        }
        originUuid = request.getHeader().getOriginUuid();
        type = request.getHeader().getType();
        command = request.getHeader().getCommand();
    }

    public ResponseBuilder<R,T> withUuid( final String uuid ) {
        this.uuid = uuid;
        return this;
    }

    public ResponseBuilder<R,T> withVersion( final String version ) {
        this.version = version;
        return this;
    }

    public ResponseBuilder<R,T> withData( final T data ) {
        this.data = data;
        return this;
    }

    public ResponseBuilder<R,T> withCode( final Integer code ) {
        this.code = code;
        return this;
    }

    public ResponseBuilder<R,T> withMessage( final String message ) {
        this.message = message;
        return this;
    }

    public Response<T> build() {
        ActionHeader header
                = new ActionHeader();
        header.setUuid(uuid);
        header.setOriginUuid(originUuid);
        header.setType(type);
        header.setCommand(command);
        header.setVersion(version);

        ResponseStatus status
                = new ResponseStatus();
        status.setCode(code);
        status.setMessage(message);

        Response<T> response
                = new Response<T>();
        response.setHeader(header);
        response.setData(data);
        response.setStatus(status);

        return response;
    }
}
