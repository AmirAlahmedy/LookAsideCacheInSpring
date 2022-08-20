package com.amir.lookasidecache;

import org.apache.shiro.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
	
	private static final String HEADER_ONE = "<h1>%s</h1>";
	
	private final CounterService counterService;
	
	public CounterController(CounterService counterService) {
		
		Assert.notNull(counterService, "CounterService is required");
		
		this.counterService = counterService;
	}
	
	@GetMapping("/")
	public String home() {
		return String.format(HEADER_ONE, "Look-Aside Caching Example");
	}
	
	@GetMapping("/ping")
	public String ping() {
		return String.format(HEADER_ONE, "PONG");
	}
	
	@GetMapping("counter/{name}")
	public String getCount(@PathVariable("name") String counterName) {
		return String.format(HEADER_ONE, counterService.getCount(counterName));
	}
	
	@GetMapping("counter/{name}/cached")
	public String getCachedCount(@PathVariable("name") String counterName) {
		return String.format(HEADER_ONE, counterService.getCachedCount(counterName));
	}
	
	@GetMapping("counter/{name}/reset")
	public String resetCounter(@PathVariable("name") String counterName) {
		counterService.resetCounter(counterName);
		return String.format(HEADER_ONE, 0);
	}
}
