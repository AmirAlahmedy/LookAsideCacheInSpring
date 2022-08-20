# LookAsideCacheInSpring
Implementation of the look aside cache pattern in Spring. I followed [this helpfule guide](https://docs.spring.io/spring-boot-data-geode-build/1.2.x/reference/html5/guides/caching-look-aside.html#geode-samples-caching-lookaside-example-run).

# Look-Aside Caching

> *Look-Aside Caching*
 is a pattern of caching where the input of a cacheable operation is used as the key for looking up any cached results from a prior invocation of the operation when given the same input.
> 

— Spring Framework Documentation

> In *Look-Aside Caching*, the cache is consulted first, before the operation is invoked, and if a computation for the given input has already been computed and cached, then the value from the cache is returned. Otherwise, if no value has been cached for the given input, or the previous cache result expired, or was evicted, then the operation will be invoked and the result of the operation is cached using the input as the key and the result as a value.

> The data structure of a cache is a key/value store, or a `Map`.

> If the result of the cacheable operation for the given input has already been computed and stored in the cache (a *cache hit*), then the result is simply returned.

> However, if the cacheable operation has never been invoked with the given input, or the previous computation of the operation for the given input expired, or was evicted, then the cacheable operation is invoked (*cache miss*). This cacheable operation may access some external data source to perform its computation. After the operation completes, it returns the result, but not before the caching infrastructure stores the result along with the input in the cache.

> Any subsequent invocation of the cacheable operation with the same input should yield the same result as stored in the cache, providing the cache entry (input→result) has not expired or been evicted.

— Spring Framework Documentation

> Different caching providers have different capabilities. You should choose the caching provider that gives you what you require to handle your application needs and use cases correctly.

— Spring Framework Documentation

## Spring’s *Cache Abstraction* using Apache Geode as the cache provider

### Description

> The example Spring Boot application implements a Counter Service, which simply maintains a collection of named counters. The application provides a REST-ful Web interface to increment a counter, get the current cached count for a named counter, and the ability to reset a named counter to 0.
> 

— Spring Framework Documentation

## When to use caching?

> Typically, caching is used to offset the costs associated with expensive operations, such as disk or network I/O. Indeed, both an operation’s throughput and latency is bound by an I/O operation since compute is many orders of magnitude faster than disk, network, etc.

>While developers have been quick to throw more Threads at the problem, trying to do more work in parallel, this opens the door to a whole new set of problems (concurrency), usually at the expense of using more resources, which does not always yield the desired results.

>Opportunities for caching are often overlooked, yet is very effective at minimizing the over utilization of resources by leveraging reuse. In an ever increasing Microservices based world, caching will become even more important as it serves a very important role in the applications architecture, not the least of which is, resiliency. 

— Spring Framework Documentation

## Tuning Caches

> pingMost caches keep information in memory, and since memory is finite, you must utilize strategies to manage memory effectively, such as eviction, expiration, or even Off-Heap (i.e. native memory) for JVM-based caches. For example, evicting/expiring entries based on use (*Least Recently Used*, or LRU) is 1 of many effective strategies.

>Each caching provider’s capabilities are different in this regard. The choice should not only be based on what capabilities you need now, but capabilities (e.g. distributed compute, streaming) you may need in the future. So, choose wisely. 

— Spring Framework Documentation

> Tuning a cache with eviction or expiration policies, perhaps using Off-Heap memory, overflowing entries to disk, making caches persistent, are few of the ways to tune or configure a cache. You might be using a client/server or even a WAN topology and you might need to configure things like conflation, filters, compression, security (e.g. SSL), and so on.

— Spring Framework Documentation
