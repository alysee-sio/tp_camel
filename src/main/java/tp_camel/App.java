package tp_camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.twitter.TwitterComponent;
import org.apache.camel.main.Main;
/**
 * Hello world!
 *
 */
public class App extends RouteBuilder {

    private static String consumerKey       = "NMqaca1bzXsOcZhP2XlwA";
    private static String consumerSecret    = "VxNQiRLwwKVD0K9mmfxlTTbVdgRpriORypnUbHhxeQw";
    private static String accessToken       = "26693234-W0YjxL9cMJrC0VZZ4xdgFMymxIQ10LeL1K8YlbBY";
    private static String accessTokenSecret = "BZD51BgzbOdFstWZYsqB5p5dbuuDV12vrOdatzhY4E";

    public static void main(String[] args) throws Exception {
        System.out.println("Lancement de CAMEL");

        App app = new App();

        Main main = new Main();
        // enable hangup support which mean we detect when the JVM terminates,
        // and stop Camel graceful
        main.enableHangupSupport();
        // add our routes to Camel
        main.addRouteBuilder(app);
        // and run, which keeps blocking until we terminate the JVM (or stop
        // CamelContext)
        main.run();
    }


    public void configure() throws Exception {
        // setup Twitter component
        TwitterComponent tc = getContext().getComponent("twitter",
                TwitterComponent.class);

        tc.setAccessToken(accessToken);
        tc.setAccessTokenSecret(accessTokenSecret);
        tc.setConsumerKey(consumerKey);
        tc.setConsumerSecret(consumerSecret);

        // endpoint
        fromF("twitter://search?type=polling&delay=%s&keywords=%s", 2, "gaga")
                .to("stream:out");
    }

}
