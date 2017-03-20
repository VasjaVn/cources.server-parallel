package com.softgroup.frontend.rest.controller;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    @Qualifier("dispatcherRouterHandler")
    private RouterHandler dispatcherRouterHandler;

    @RequestMapping(value = {"/rest"}, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Response<?> rest(@RequestBody Request<?> request) {
        return dispatcherRouterHandler.handle(request);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "___hello___";
    }


    @RequestMapping("/dispatcher")
    @ResponseBody
    public String dispatcher() {
        return dispatcherRouterHandler.getName();
    }
}
