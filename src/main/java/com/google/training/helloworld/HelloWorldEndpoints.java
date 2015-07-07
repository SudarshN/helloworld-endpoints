package com.google.training.helloworld;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;


import static com.google.devrel.training.helloworld.service.OfyService.factory;
import static com.google.devrel.training.helloworld.service.OfyService.ofy;

import com.google.training.helloworld.HelloClass;
import com.googlecode.objectify.Key;
/**
 * Defines endpoint functions APIs.
 */
@Api(name = "helloworldendpoints", version = "v1",
scopes = {Constants.EMAIL_SCOPE },
        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for hello world endpoints.")

public class HelloWorldEndpoints {

   // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHello", path = "sayHello",
            httpMethod = HttpMethod.GET)

    public HelloClass sayHello() {
    	final Key<HelloClass> goalKey = factory().allocateId( HelloClass.class);
    	Long id = goalKey.getId();
		
    	HelloClass hello = new HelloClass(id);
    	ofy().save().entity(hello).now();
        return hello;
    }

    // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHelloByName", path = "sayHelloByName",
            httpMethod = HttpMethod.GET)

    public HelloClass sayHelloByName (@Named("name") String name) {
    	final Key<HelloClass> goalKey = factory().allocateId( HelloClass.class);
    	Long id = goalKey.getId();
		
    	HelloClass hello = new HelloClass(id,name);
    	ofy().save().entity(hello).now();
        return hello;
    }
}
