package org.acko.smartlife.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author prabodh.hend
 */
@Configuration
@Data
@EnableCaching
@EnableAsync
public class AppConfig implements ApplicationContextAware {

    @Autowired
    private Environment environment;

    private ApplicationContext appContext;

    public void setApplicationContext(ApplicationContext context) {
        this.appContext = context;
    }
}
