package works.weave.socks.cart;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnablePrometheusEndpoint
public class CartApplication {
    private static final Logger logger = LoggerFactory.getLogger("Main");
    static ConfigurableApplicationContext ctx;
    public static void main(String[] args) {
        ctx = SpringApplication.run(CartApplication.class, args);
    }

    public static void exitApplication() {
        logger.error("CLOSING APP!");
        int returnCode = -1;
        int exitCode = SpringApplication.exit(ctx, () -> returnCode);
        System.exit(exitCode);
    }
}
