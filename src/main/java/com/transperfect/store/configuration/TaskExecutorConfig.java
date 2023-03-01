package com.transperfect.store.configuration;

import com.transperfect.store.properties.ThreadPoolProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TaskExecutorConfig {

    private final ThreadPoolProperties threadPoolProperties;

    @Bean(name = "TaskExecutor")
    @Primary
    public TaskExecutor taskExecutor()
    {
        log.info("Creating Async Task Executor, properties {}", threadPoolProperties);
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolProperties.getCoreSize());
        executor.setMaxPoolSize(threadPoolProperties.getMaxSize());
        executor.setThreadNamePrefix("Custom_Thread-");
        executor.initialize();
        return executor;
    }
}
