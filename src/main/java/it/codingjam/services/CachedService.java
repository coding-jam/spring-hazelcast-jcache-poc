package it.codingjam.services;

import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheResult;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class CachedService {

    private static final Logger LOGGER = Logger.getLogger(CachedService.class.getName());

    @CacheResult(cacheName = "default")
    public String timeConsumingOperation() throws InterruptedException {
        LOGGER.info("Time consuming op");
        TimeUnit.SECONDS.sleep(3);
        return "pong";
    }
}
