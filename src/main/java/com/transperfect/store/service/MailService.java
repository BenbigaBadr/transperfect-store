package com.transperfect.store.service;

import com.transperfect.store.dto.MailDTO;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

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

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, StandardCharsets.UTF_8.name());

            messageHelper.setFrom(mailDetails.getFrom());
            messageHelper.setTo(mailDetails.getTo());
            messageHelper.setSubject(mailDetails.getSubject());
            messageHelper.setText(mailDetails.getMessage(), Boolean.TRUE);
            mailSender.send(mimeMessage);

            log.info("Email Sent to {}, from {}, message {}", mailDetails.getTo(), mailDetails.getFrom(), mailDetails.getMessage());
        }
        catch (Exception e) {
            log.error("An error has occurred while sending email {}", e);
        }
    }
}
