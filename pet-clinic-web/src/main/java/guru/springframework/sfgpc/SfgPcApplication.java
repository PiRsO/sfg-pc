package guru.springframework.sfgpc;

import guru.springframework.sfgpc.controllers.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgPcApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SfgPcApplication.class);

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------");
        ApplicationContext context = SpringApplication.run(SfgPcApplication.class, args);

        IndexController indexController = (IndexController) context.getBean("indexController", IndexController.class);

        LOGGER.info(indexController != null ? "it's OK" : "IT ISN'T OK" );
    }
}
