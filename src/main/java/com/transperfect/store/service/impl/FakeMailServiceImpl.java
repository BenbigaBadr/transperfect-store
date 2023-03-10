package com.transperfect.store.service.impl;

import com.transperfect.store.dto.MailDTO;
import com.transperfect.store.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("test")
public class FakeMailServiceImpl implements MailService {
    @Override
    public void sendMail(MailDTO mailDetails) {
        log.info("SENDING EMAIL ....");
    }
}
