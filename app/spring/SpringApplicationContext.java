package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.Configuration;
import play.Logger;

import java.util.Map;

public class SpringApplicationContext {
    private static AnnotationConfigApplicationContext ctx;
    private static final String[] BASE_PACKAGES = new String[] {
            "spring",
            "controllers"
    };

    public static void initialize() {
        try {
            String profile = Configuration.root().getString("profile");
            Logger.info("Profile: " + profile);
            ctx = new AnnotationConfigApplicationContext();
            ctx.getEnvironment().setActiveProfiles(profile);
            ctx.scan(BASE_PACKAGES);
            ctx.refresh();
        } catch (Exception e) {
            throw new IllegalStateException("application context could not be initialized properly", e);
        }
    }

    public static <T> T getBean(Class<T> beanClass) {
        return ctx.getBean(beanClass);
    }

    public static <T> Map<String, T> getBeans(Class<T> beanClass) {
        return ctx.getBeansOfType(beanClass);
    }

    public static <T> T getBeanNamed(String beanName, Class<T> beanClass) {
        return ctx.getBean(beanName, beanClass);
    }

    public static void close() {
        if (ctx != null) {
            ctx.close();
            ctx.destroy();
            ctx = null;
        }
    }
}
