package com.dxctraining;

import com.dxctraining.consumer.controllers.ConsumerJerseyController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(ConsumerJerseyController.class);
    }

}