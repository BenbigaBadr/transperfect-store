package com.transperfect.store.service;

import com.transperfect.store.dto.MailDTO;

public interface MailService {
    void sendMail(MailDTO mailDetails);
}
