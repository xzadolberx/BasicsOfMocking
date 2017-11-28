import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.TestCase.assertTrue;


public class MockSetup {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    @Test
    public void mockPostitive() {
        stubFor(get(anyUrl()). // urlEqualTo("/") / urlMatching("")
                willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "text/plain") // "application/json"
                .withBody("status: reply\n" +
                        "content-type: text/plain\n" +
                        "concat_type: SMPP_TRUNCATE\n" +
                        "destination: 79773067305\n" +
                        " \n" +
                        "My msg")
        ));
        System.out.println("Started!");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    public static void mock1() {
        configureFor("localhost", 8082);
        stubFor(get(anyUrl()). // urlEqualTo("/") / urlMatching("")
                willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "text/plain") // "application/json"
                .withBody("status: reply\n" +
                        "content-type: text/plain\n" +
                        "concat_type: SMPP_TRUNCATE\n" +
                        "destination: 79775550017\n" +
                        " \n" +
                        "My Message Сообщение.")
        ));
    }

    public static void mock2() {
        configureFor("localhost", 8082);
        stubFor(get(anyUrl()). // urlEqualTo("/") / urlMatching("")
                willReturn(aResponse()
                .withStatus(500)
                .withHeader("Content-Type", "text/plain") // "application/json"
                .withBody("Test the error")
        ));
    }
    */
}
