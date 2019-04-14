package br.com.jcsw.springcachetest.driver.cache;

import java.util.concurrent.TimeUnit;
import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cache2kConfiguration {

  @Bean
  public CacheManager cacheManager() {
    return new SpringCache2kCacheManager()
        .addCaches(b -> b.name("books").expireAfterWrite(5, TimeUnit.MINUTES).entryCapacity(500_000));
  }

}
