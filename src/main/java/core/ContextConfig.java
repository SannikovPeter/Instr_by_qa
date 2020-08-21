package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class ContextConfig {

    private static final Logger logger = LoggerFactory.getLogger(core.ContextConfig.class);

    public ContextConfig() {
        logger.info("Контекст загрузился");
    }

    @Bean
    public BrowserManager browserManager() {
        logger.info("Бин BrowserManager создан");
        return new BrowserManager();
    }
}
