package com.amir.lookasidecache;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LookAsideCacheApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LookAsideCacheApplication.class)
		.web(WebApplicationType.SERVLET)
		.build()
		.run(args);
	}

}
