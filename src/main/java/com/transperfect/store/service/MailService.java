package com.transperfect.store.service;

import com.transperfect.store.dto.MailDTO;
import com.transperfect.store.exception.BusinessException;
import com.transperfect.store.exception.TechnicalException;
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
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(mailDetails.getFrom());
            mailMessage.setTo(mailDetails.getTo());
            mailMessage.setText(mailDetails.getMessage());
            mailMessage.setSubject(mailDetails.getSubject());

            // Sending the mail
            mailSender.send(mailMessage);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
