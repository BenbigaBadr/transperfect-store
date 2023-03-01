package com.transperfect.store.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "thread.pool")
@Getter
@Setter
public class ThreadPoolProperties {
    private int coreSize;
    private int maxSize;
}
