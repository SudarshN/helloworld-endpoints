package com.google.training.helloworld;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class HelloClass {
	 @Id
	 Long userId;
    public String message = "Hello World";

    public HelloClass (Long Id) {
    	this.userId = Id;
    }

    public HelloClass (Long Id,String name) {
        this.message = "Hello " + name + "!";
    }

    public String getMessage() {
        return message;
    }
}
