package com.micro.demoproject.controller;

import com.micro.demoproject.data.request.SomeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Some Api Tag")
public interface DemoApi {

    @ApiOperation(value = "Do something.",
            notes = "There is explained something else."
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Description."),
            @ApiResponse(code = 400, message = "Description."),
            @ApiResponse(code = 404, message = "Description."),
            @ApiResponse(code = 500, message = "Description."),
    })
    void inputSomething(SomeRequest someRequest);
}
