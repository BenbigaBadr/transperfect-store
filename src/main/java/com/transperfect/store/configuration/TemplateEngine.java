package com.transperfect.store.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Component
public class TemplateEngine {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public String generateHtml(String templateName, Context context)
    {
        return templateEngine.process(templateName, context);
    }
}
