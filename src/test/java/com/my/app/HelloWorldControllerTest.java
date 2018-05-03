package com.my.app;

import org.junit.Test;

import junit.framework.Assert;

public class HelloWorldControllerTest {

	@Test
	public void helloWorldTest() {
		
		HelloWorldController controller = new HelloWorldController();
		Assert.assertEquals("Hello World!", controller.home());
	}
}
