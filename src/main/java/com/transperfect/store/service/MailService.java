package com.transperfect.store.service;

import com.transperfect.store.dto.MailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;

    @Async("TaskExecutor")
    public void sendMail(MailDTO mailDetails)
    {
        log.info("SENDING EMAIL ....");
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(mailDetails.getFrom());
            mailMessage.setTo(mailDetails.getTo());
            mailMessage.setText(mailDetails.getMessage());
            mailMessage.setSubject(mailDetails.getSubject());
            mailSender.send(mailMessage);
        }
        catch (Exception e) {
            log.error("An error has occurred while sending email {}", e);
        }
    }
}
