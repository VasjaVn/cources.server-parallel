package com.softgroup.common.protocol;

import java.util.UUID;

public class RequestBuilder<T extends RequestData> {

    private String uuid = "";
    private String originUuid = UUID.randomUUID().toString();
    private String type;
    private String command;
    private String version = ProtocolVersion.VERSION_1.toString();

    private T data;

    public RequestBuilder<T> withOriginUuid( final String originUuid ) {
        this.originUuid = originUuid;
        return this;
    }

    public RequestBuilder<T> withType( final String type ) {
        this.type = type;
        return this;
    }

    public RequestBuilder<T> withCommand( final String command ) {
        this.command = command;
        return this;
    }

    public RequestBuilder<T> withVersion( final String version ) {
        this.version = version;
        return this;
    }

    public RequestBuilder<T> withData(final T data ) {
        this.data = data;
        return this;
    }

    public Request<T> build() {
        ActionHeader header = new ActionHeader();
        header.setUuid(uuid);
        header.setOriginUuid(originUuid);
        header.setType(type);
        header.setCommand(command);
        header.setVersion(version);

        Request<T> request = new Request<T>();
        request.setHeader(header);
        request.setData(data);

        return request;
    }
}
