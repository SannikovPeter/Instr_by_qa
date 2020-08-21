package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext {

    private final static ApplicationContext context = new AnnotationConfigApplicationContext(core.ContextConfig.class);

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> var1) {
        return getContext().getAutowireCapableBeanFactory().getBean(var1);
    }

}
