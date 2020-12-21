package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import main.service.LongToShortUrlService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest{


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }


    @Test
    public void testGetShortUrl() throws Exception {

        LongToShortUrlService service = new LongToShortUrlService();
        service.init();

        service.getShortenedURL("github.com", 1);
        service.getShortenedURL("twitter.com", 1);
        service.getShortenedURL("twitter.com", 2);
        service.getOriginalURL("dnh");
        service.getShortenedURL("twitter.com", 2);
        assertEquals("dnh\ndni\ndnj\ngithub.com\ndnj", outContent.toString().trim());
    }

}