package ru.gvg.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author Valeriy Gyrievskikh
 * @since 19.08.2018.
 */
@SpringBootApplication
@IntegrationComponentScan
public class ServerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ServerApplication.class, args);
        String response = context.getBean(RequestGateway.class).echo("hello");
        System.out.println(response);
        context.close();
    }
    @ServiceActivator(inputChannel="receiveChannel")
    public String controller(String payload) {
        return String.
                format("Re: `%s' from over side via controller", payload);
    }
    public interface RequestGateway {
        String echo(String request);
    }
}

