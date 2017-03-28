package it.codingjam.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.test.context.junit4.SpringRunner;

import javax.cache.CacheManager;
import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CachedResourceTest {

    @Inject
    private TestRestTemplate testRestTemplate;

    @Inject
    private CacheManager cacheManager;

    @Test
    public void shouldReturnPong() throws Exception {
        assertFalse(cacheManager.getCache("default").containsKey(SimpleKey.EMPTY));
        String response = testRestTemplate.getForObject("/cached", String.class);

        assertEquals("pong", response);
        assertTrue(cacheManager.getCache("default").containsKey(SimpleKey.EMPTY));
    }

}