package it.codingjam.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by acomo on 01/04/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CachedServiceTest {

    @Inject
    private CachedService cachedService;

    @Test
    public void shouldUpdateCacheForEchoMessage() {
        String echoMessage = cachedService.echo("me");
        assertEquals("ECHO me", echoMessage);

        cachedService.updateEchoPhraseFor("me", "DOUBLE ECHO me");

        echoMessage = cachedService.echo("me");
        assertEquals("DOUBLE ECHO me", echoMessage);
    }

    @Test
    public void shouldResetEchoPhrase() {
        String echoMessage = cachedService.echo("me");
        assertEquals("ECHO me", echoMessage);

        cachedService.updateEchoPhraseFor("me", "DOUBLE ECHO me");

        echoMessage = cachedService.echo("me");
        assertEquals("DOUBLE ECHO me", echoMessage);

        cachedService.resetEchoPhrase("me");

        echoMessage = cachedService.echo("me");
        assertEquals("ECHO me", echoMessage);
    }

}