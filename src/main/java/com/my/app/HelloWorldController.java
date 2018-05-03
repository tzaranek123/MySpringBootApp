package com.my.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@EnableAutoConfiguration
public class HelloWorldController {

	private static final String templateString = "Hello %s.";
	
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path="/world", produces = "application/json")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Greeting greeting(@RequestParam(value="name", defaultValue="John") String name) {
        return new Greeting(1, String.format(templateString,name));
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldController.class, args);
    }    
}
