package com.amir.lookasidecache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
	
	private ConcurrentHashMap<String, AtomicLong> namedCounterMap = new ConcurrentHashMap<>();
	
	@Cacheable("Counters")
	public long getCachedCount(String counterName) {
		return getCount(counterName);
	}
	
	@CachePut("Counter")
	public long getCount(String counterName) {
		
		AtomicLong counter = namedCounterMap.get(counterName);
		
		if(counter == null) {
			
			counter = new AtomicLong(0L);
			
			AtomicLong existingCounter = namedCounterMap.putIfAbsent(counterName, counter);
			
			counter = existingCounter != null ? existingCounter : counter;
		}
		
		return counter.incrementAndGet();
	}
	
	@CacheEvict("Counters")
	public void resetCounter(String counterName) {
		this.namedCounterMap.remove(counterName);
	}
}
