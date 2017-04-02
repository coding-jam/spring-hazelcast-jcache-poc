package it.codingjam.services;

import org.springframework.stereotype.Service;

import javax.cache.annotation.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
@CacheDefaults(cacheName = "default")
public class CachedService {

    private static final Logger LOGGER = Logger.getLogger(CachedService.class.getName());

    @CacheResult
    public String timeConsumingOperation() throws InterruptedException {
        LOGGER.info("Time consuming op");
        TimeUnit.SECONDS.sleep(3);
        return "pong";
    }

    @CacheResult
    public String echo(String text) {
        return "ECHO " + text;
    }

    @CachePut
    public void updateEchoPhraseFor(String text, @CacheValue String newEcho) {
        // nop
    }

    @CacheRemove
    public void resetEchoPhrase(String text) {
        // nop
    }
}
