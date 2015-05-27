package com.wiley.beginningspring.ch10;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by mertcaliskan
 * on 20/08/14.
 */
@Configuration
@ComponentScan(basePackages = {"com.wiley.beginningspring.ch10"})
@EnableCaching
public class ApplicationConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("users")));
        return cacheManager;
    }
}
