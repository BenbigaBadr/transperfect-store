package com.transperfect.store.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Component
@RequiredArgsConstructor
public class TemplateEngine {

    private final SpringTemplateEngine springTemplateEngine;

    public String generateHtml(String templateName, Context context)
    {
        return springTemplateEngine.process(templateName, context);
    }
}
