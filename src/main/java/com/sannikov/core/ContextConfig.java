package com.sannikov.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sannikov")
public class ContextConfig {

    private static final Logger logger = LoggerFactory.getLogger(ContextConfig.class);

    public ContextConfig() {
        logger.info("Context is loaded");
    }
}
