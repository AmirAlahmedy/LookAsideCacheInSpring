package com.amir.lookasidecache;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLogging;


@Configuration
@EnableLogging(logLevel = "error")
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
public class GeodeConfiguration {}
