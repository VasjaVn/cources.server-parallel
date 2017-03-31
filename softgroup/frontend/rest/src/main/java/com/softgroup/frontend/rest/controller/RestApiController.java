package com.softgroup.frontend.rest.controller;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.FilterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    @Qualifier("publicFilterHandler")
    private FilterHandler publicFilterHandler;

    @Autowired
    @Qualifier("privateFilterHandler")
    private FilterHandler privateFilterHandler;

    @ResponseBody
    @RequestMapping(value = {"/public"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Response<?> publicRestApi(@RequestBody Request<?> request) {
        return publicFilterHandler.handle(request);
    }

    @ResponseBody
    @RequestMapping(value = {"/private"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Response<?> privateRestApi(@RequestBody Request<?> request) {
        return privateFilterHandler.handle(request);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("___hello___");
        return "___hello___";
    }
}